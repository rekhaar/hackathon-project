package com.abc.app.mortgage.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.app.mortgage.dto.ErrorResponse;
import com.abc.app.mortgage.dto.TransferRequest;
import com.abc.app.mortgage.dto.TransferResponse;
import com.abc.app.mortgage.service.AccountService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/accounts")
@SecurityRequirement(name = "basicAuth")
@Validated
public class AccountsController {

	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("/transfer")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> transferFunds(@RequestBody  @Validated TransferRequest transferRequest, Principal principal) {
		try {
			TransferResponse response = accountService.transferFunds(principal.getName(), transferRequest);
			return ResponseEntity.ok(response);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(new ErrorResponse("failed",e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ErrorResponse("failed",e.getMessage()));
		}
	}
}
