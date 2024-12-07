package com.abc.app.mortgage.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {
	
	  public static LocalDateTime getCurrentTimestamp() {
	        return LocalDateTime.now();
	    }
	  
	  public static String generateTransactionRef() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	        String timestamp = LocalDateTime.now().format(formatter);
	        int randomNumber = new Random().nextInt(900000) + 100000; // 6-digit random number
	        return "TXN" + timestamp + randomNumber;
	    }

}
