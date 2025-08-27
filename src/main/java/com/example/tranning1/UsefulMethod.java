package com.example.tranning1;

import java.security.SecureRandom;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsefulMethod {
	

	static String COOKIE_NAME="Nepathya";
	
	static String sampleSpace="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	static int SIZE=sampleSpace.length();

	public static String getRandomString(int len)
	{
		SecureRandom random=new SecureRandom();
		String ans="";
		
		for(int i=1;i<=len;i++)
		{
		 int index=random.nextInt(SIZE);	
		 ans+=sampleSpace.charAt(index);
		}
	  
		return ans;	
	}
}
