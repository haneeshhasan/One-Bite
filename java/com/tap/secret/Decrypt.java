package com.tap.secret;

public class Decrypt {

	
	public static String decrypt(String str) {
		
		String newStr="";
		for(int i=0;i<str.length();i++) {
			newStr= newStr+((char) (str.charAt(i)-Secret.getKey()));
		}
		return newStr;
	}
}
