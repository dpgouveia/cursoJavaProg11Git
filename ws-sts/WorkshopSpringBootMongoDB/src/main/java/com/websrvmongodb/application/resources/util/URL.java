package com.websrvmongodb.application.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String rawText) {
		
		try {
			return URLDecoder.decode(rawText, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	
	}
	
}
