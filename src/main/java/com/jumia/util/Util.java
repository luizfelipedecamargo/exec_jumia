package com.jumia.util;

import java.util.Collection;
import java.util.regex.Pattern;

public class Util {
	
	public static boolean isEmpty(Object objeto){
		if(objeto instanceof String){
			if(objeto == null || objeto.equals("") || objeto.equals("undefined"))
				return true;
		}else if(objeto instanceof Collection){
			Collection vr = (Collection)objeto;
			if(vr == null || vr.isEmpty())
				return true;
		}else if(objeto == null){
			return true;
		}
		return false;
	}
	
	public static boolean isValid(String phoneNumber, long countrId) {
		
		switch ((int) countrId) {
		
		case 237:
			return Pattern.matches("\\(237\\)\\ ?[2368]\\d{7,8}$", formatPhone(phoneNumber, countrId));			
			
		case 251:
			return Pattern.matches("\\(251\\)\\ ?[1-59]\\d{8}$", formatPhone(phoneNumber, countrId));
			
		case 212:
			return Pattern.matches("\\(212\\)\\ ?[5-9]\\d{8}$", formatPhone(phoneNumber, countrId));
			
		case 258:
			return Pattern.matches("\\(258\\)\\ ?[28]\\d{7,8}$", formatPhone(phoneNumber, countrId));
			
		case 256:
			return Pattern.matches("\\(256\\)\\ ?\\d{9}$", formatPhone(phoneNumber, countrId));			

		default:
			return false;
		}
		
	}
	
	private static String formatPhone(String phoneNumber, long countrId) {
		return "(" + countrId + ")".concat(phoneNumber);
	}
	
	
}
