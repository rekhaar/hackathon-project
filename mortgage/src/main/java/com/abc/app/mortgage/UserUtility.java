package com.abc.app.mortgage.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UserUtility {

	public UserUtility() {
		// TODO Auto-generated constructor stub
	}

	public String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
		LocalDateTime date=		LocalDateTime.now();
		String d = dtf.format( date);
		return d;
	}
}
