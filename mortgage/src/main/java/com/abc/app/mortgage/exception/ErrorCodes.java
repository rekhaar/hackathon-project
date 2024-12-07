package com.abc.app.mortgage.exception;

public class ErrorCodes {

    public static final String ERR_VALIDATION_FROM_ACCOUNT = "ERR_VALIDATION_FROM_ACCOUNT";
    public static final String ERR_VALIDATION_FROM_ACCOUNT_MSG = "From Account ID is invalid or missing";

    public static final String ERR_VALIDATION_TO_ACCOUNT = "ERR_VALIDATION_TO_ACCOUNT";
    public static final String ERR_VALIDATION_TO_ACCOUNT_MSG = "To Account ID is invalid or missing";

    public static final String ERR_VALIDATION_AMOUNT = "ERR_VALIDATION_AMOUNT";
    public static final String ERR_VALIDATION_AMOUNT_MSG = "Amount is invalid or missing";

    public static final String ERR_VALIDATION_INSTRUCTIONS = "ERR_VALIDATION_INSTRUCTIONS";
    public static final String ERR_VALIDATION_INSTRUCTIONS_MSG = "Instructions exceed character limit";

    public static final String ERR_TRANSFER_SAME_ACCOUNT = "ERR_TRANSFER_SAME_ACCOUNT";
    public static final String ERR_TRANSFER_SAME_ACCOUNT_MSG = "From and To Account IDs cannot be the same";

    public static final String ERR_TRANSFER_INSUFFICIENT_BALANCE = "ERR_TRANSFER_INSUFFICIENT_BALANCE";
    public static final String ERR_TRANSFER_INSUFFICIENT_BALANCE_MSG = "Insufficient balance in savings account";

    public static final String ERR_TRANSFER_NO_OUTSTANDING = "ERR_TRANSFER_NO_OUTSTANDING";
    public static final String ERR_TRANSFER_NO_OUTSTANDING_MSG = "Mortgage account has no outstanding amount";

    public static final String ERR_TRANSFER_EXCEEDS_OUTSTANDING = "ERR_TRANSFER_EXCEEDS_OUTSTANDING";
    public static final String ERR_TRANSFER_EXCEEDS_OUTSTANDING_MSG = "Transfer amount exceeds outstanding balance";

    public static final String ERR_SYSTEM_DATABASE = "ERR_SYSTEM_DATABASE";
    public static final String ERR_SYSTEM_DATABASE_MSG = "Database error occurred";

    public static final String ERR_SYSTEM_UNKNOWN = "ERR_SYSTEM_UNKNOWN";
    public static final String ERR_SYSTEM_UNKNOWN_MSG = "Unknown system error occurred";

}

