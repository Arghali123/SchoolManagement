package com.example.tranning1;

public class ShoppingItem 
{
 private String item;
 private String user;
 
 ShoppingItem(String item,String user)
 {
	 this.item=item;
	 this.user=user;
 }
 
 public void setItem(String item)
 {
	 this.item=item;
 }
 String getItem()
 {
	 return item;
 }
 
 
 public void setUser(String user)
 {
	 this.user=user;
 }
 String getUser()
 {
	 return user;
 }
 
}
