package com.abc.app.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.app.mortgage.dto.TransferRequest;
import com.abc.app.mortgage.dto.TransferResponse;
import com.abc.app.mortgage.entity.Account;
import com.abc.app.mortgage.entity.TransactionSummary;
import com.abc.app.mortgage.entity.User;
import com.abc.app.mortgage.repository.AccountRepository;
import com.abc.app.mortgage.repository.TransactionRepository;
import com.abc.app.mortgage.repository.UserRepository;
import com.abc.app.mortgage.util.AccountType;
import com.abc.app.mortgage.util.Utils;

@Service
public class AccountService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Transactional
	public TransferResponse transferFunds(String userName, TransferRequest request) {

		if (request.getFromAccountId().equals(request.getToAccountId()))
			throw new IllegalArgumentException("Both accounts can not be same ");

		User user = userRepository.findByUserName(userName)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));
		Long userId = user.getId();

		Account savingsAccount = accountRepository.findByAccountIdAndAccountTypeAndUserIdAndIsActive(request.getFromAccountId(),
				AccountType.SAVINGS.getCode(), userId,true)
				.orElseThrow(() -> new IllegalArgumentException("Savings account not found"));

		Account mortgageAccount = accountRepository.findByAccountIdAndAccountTypeAndUserIdAndIsActive(request.getToAccountId(),
				AccountType.MORTGAGE.getCode(), userId,true)
				.orElseThrow(() -> new IllegalArgumentException("Mortgage account not found"));

		if (savingsAccount.getBalanceAmount().compareTo(request.getAmount()) < 0) {
			throw new IllegalArgumentException("Insufficient funds in savings account");
		}

		if (mortgageAccount.getBalanceAmount().compareTo(request.getAmount()) < 0) {
			throw new IllegalArgumentException("Payment amount exceeds outstanding amount in mortgage account");
		}

		savingsAccount.setBalanceAmount(savingsAccount.getBalanceAmount().subtract(request.getAmount()));
		mortgageAccount.setBalanceAmount(mortgageAccount.getBalanceAmount().subtract(request.getAmount()));

		accountRepository.save(savingsAccount);
		accountRepository.save(mortgageAccount);

		TransactionSummary ts = new TransactionSummary();

		ts.setSrcAccountId(request.getFromAccountId());
		ts.setDestAccountId(request.getToAccountId());
		ts.setIsComplete(true);
		ts.setTransferAmount(request.getAmount());
		ts.setTransferRefNo(Utils.generateTransactionRef());
		ts.setCreateDate(Utils.getCurrentTimestamp());
		ts.setUpdateDate(Utils.getCurrentTimestamp());
		ts.setUserId(userId);
		ts.setRemarks(request.getInstructions());

		transactionRepository.save(ts);

		return new TransferResponse("success","Transfer successful", savingsAccount.getBalanceAmount(),
				mortgageAccount.getBalanceAmount());
	}
}
