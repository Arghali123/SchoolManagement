package com.example.tranning1;

import java.security.SecureRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsefulMethod {

	static String sampleSpace="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	static int SIZE=sampleSpace.length();
	
	@GetMapping("/generateRadom/{num}")
	public String getRandomString(@PathVariable("num") int len)
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
