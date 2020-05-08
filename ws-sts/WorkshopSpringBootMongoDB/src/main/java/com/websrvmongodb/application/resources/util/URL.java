package com.websrvmongodb.application.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.format.DateTimeParseException;

public class URL {

	public static String decodeParam(String rawText) {

		try {
			return URLDecoder.decode(rawText, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}

	}
	
	public static Instant convertDate(String textDate, Instant defaultValue) {
		try {
			return Instant.parse(textDate + "T00:00:00.00Z");	
		} catch (DateTimeParseException e) {
			return defaultValue;
		}
	}

}
