package com.example.tranning1;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {
	int count=0;

	@GetMapping("/greet")
	public String greet()
	{
		
		return "hello world";
	}
	
	@GetMapping("/count")
	public String pageVisits()
	{
		count++;
		return "Page Visited "+count+" times";
	}
	
	@GetMapping("/dice")
	public String dice()
	{
		int val=(new Random()).nextInt(6)+1;
		String roll="";
		switch(val)
		{
		case 1:
			roll="ONE";
			break;
			
		case 2:
			roll="	TWO";
			break;
			
		case 3:
			roll="THREE";
			break;
			
		case 4:
			roll="FOUR";
			break;
			
		case 5:
			roll="FIVE";
			break;
			
		case 6:
			roll="SIX";
			break;
			
		default:
			roll="UNKNOWN";
		
		}
		return "Your rolled: " + roll + " (" + val + ")<br>" +
	       "<a href=\"/dice\">Roll a dice</a>";

	}
	
	 @GetMapping("/home")
	 public String getHomePage()
	 {
		 return """
		 		<a href="/greet">Greet Page</a><br>
		 		<a href="/count">Count Page</a><br>
		 		<a href="/dice">Roll a dice</a><br>
		 		""";
	 }
	 
	 @GetMapping("/para/{num}")
	 public String generateParagrahp(@PathVariable("num")int count)
	 {
		 String[] lines= {
				 "I used this. It takes phrases from Noam Chomsky and generates random paragraphs. You can change",
                 "the feedstock text to whatever you want.",
                 "This section provides a brief overview of Spring Boot reference documentation.",
                 "hwekkwfewfenferfbf ejfefbefre refrebef",
                 "wefwe wedjwebwer ewrwhe  werjwewe ewerb "
		 };
		 Random  r=new Random();
		 String out="";
		 for(int i=1;i<=count;i++)
		 {
			 int index=r.nextInt(lines.length);
			 out=out+lines[index];
			 out=out+"<br>";
		 }
		 return out;
	 }
	 
	 @GetMapping("/multiples/{limit}")
	 public String multiples(@PathVariable("limit") int l)
	 {
		 int font_size=12;
		 String result="";
		 for(int i=7;i<=l;i=i+7)
		 {
			 result=result+"<p style=\"font-size:"+font_size+"\">"+i+"</p>";
			 font_size+=2;
		 }
		 return result;
	 }
}
