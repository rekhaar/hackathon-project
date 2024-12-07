package com.abc.app.mortgage.converter;

import com.abc.app.mortgage.dto.AccountDTO;
import com.abc.app.mortgage.entity.Account;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class AccountConverter extends ABCConverter<AccountDTO, Account> {
    public AccountConverter() {
        super(AccountConverter::convertDtoToEntity,AccountConverter::convertEntityToDto);
    }
    private static AccountDTO convertEntityToDto(Account entity) {
       return new AccountDTO(entity.getId(),entity.getAccountNumber(),entity.getAccountName(),entity.getUserId(),entity.getBalanceAmount());
    }

    private static Account convertDtoToEntity(AccountDTO dto) {
      return  new Account(dto.id(), dto.accountNumber(),dto.accountName(),dto.userId(),dto.accountBalance());
    }
}
