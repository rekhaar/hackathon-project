package com.abc.app.mortgage.controller;
import com.abc.app.mortgage.request.AccountRequest;
import com.abc.app.mortgage.response.AccountResponse;
import com.abc.app.mortgage.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
 class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    @Test
     void shouldReturnAccountsForValidRequest() throws Exception {
        // Arrange
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setUserId(String.valueOf(1L));

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountNumber(101L);
        accountResponse.setAccountType("Savings Account");

        List<AccountResponse> accountResponses = Arrays.asList(accountResponse);

        // Mocking the service call
        when(accountService.getAccountsByUserId(accountRequest)).thenReturn(accountResponses);

        // Act
        ResultActions resultActions = mockMvc.perform(post("/api/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": 1}"));

        // Assert
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].accountNumber").value(101L))
                .andExpect(jsonPath("$[0].accountType").value("Savings Account"));

        verify(accountService, times(1)).getAccountsByUserId(accountRequest);
    }

    @Test
    void shouldReturnBadRequestForInvalidRequest() throws Exception {
        // Act
        ResultActions resultActions = mockMvc.perform(post("/api/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")); // Empty request body (assuming validation is on userId)

        // Assert
        resultActions.andExpect(status().isBadRequest());
    }
}
