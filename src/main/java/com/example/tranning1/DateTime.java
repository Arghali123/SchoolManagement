package com.example.tranning1;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTime 
{
 @GetMapping("/time")
 public String dateTime()
 {
	 Date date=new Date();
	 return "Current time: "+date;
 }
 
 @GetMapping("/square/{num}")
 public String square(@PathVariable("num") int n)
 {
	 return n+"^2= "+n*n;
 }
 
 @GetMapping("multiply/{num1}/{num2}")
 public String muliply(@PathVariable("num1") int a,@PathVariable("num2") int b)
 {
	 return a+"X"+b+" = "+a*b;
 }
 

}
