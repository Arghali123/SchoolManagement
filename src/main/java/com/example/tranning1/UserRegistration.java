package com.example.tranning1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UserRegistration {

	 static List<LoginInfo> allLoggedInUsers=new ArrayList<>();
	
	@GetMapping("/")
	public String getHomePage(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		//Check if user has token in their cookies
		LoginInfo info=UsefulMethod.getLoggedInUser(request);
		if(info!=null)
		{
			return "<h2>Hello,"+info.getUsername()+"!</h2>"+"""
					<a href="/profile">Profile</a>
					"""+"<p>Name: "+info.getFullname()+",Emai: "+info.getEmail()+"</p>";
		}else
		{
			response.sendRedirect("/login");
		}
		return "";
	}
	
	@GetMapping("/login")
    public String getLoginPage()
    {
		return """
				<form action="/login/save" method="get">
				  <input type="text" placeholder="Username" name="username"/>
				  <input type="submit" value="LOGIN"/>
				</form>
				""";
    }
	
	@GetMapping("/profile")
	public String getProfilePage(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
      LoginInfo info=UsefulMethod.getLoggedInUser(request);
      if(info!=null)
      {
    	  //user's cookie has SECUREID(which was probably given by the server
    	  return "<h2>Hello,"+info.getUsername()+"!</h2>"+"""
    	  		  <form action="/profile/save" method="get">
    	  		   <input type="text" placeholder="Full Name" name="fullname"/>
    	  		   <input type="email" placeholder="Email" name="email"/>
    	  		   <input type="submit" value="SAVE"/>
    	  		  </form>
    	  		""";
      }else
      {
    	  response.sendRedirect("/login");
      }
      return "";
	}
	

	@GetMapping("/profile/save")
	public String saveProfile(@RequestParam("fullname") String fullName,@RequestParam("email") String email,
			HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		LoginInfo info=UsefulMethod.getLoggedInUser(request);
		if(info!=null)
		{
			//actually save the fullname and email in database
			info.setFullname(fullName);
			info.setEmail(email);
			response.sendRedirect("/");
		}else
		{
			response.sendRedirect("/login");
		}
		return "";
	}
	
	
	@GetMapping("/login/save")
	public String saveLoginPage(@RequestParam("username") String username,HttpServletResponse response)throws IOException
	{
		//TODO: generate,save and provide new token to the user.
		
		//1.)Generate token
		String token=UsefulMethod.getRandomString(10);
		
		//2.) Save token to database along with the username
		LoginInfo loginInfo=new LoginInfo(username,token);
		allLoggedInUsers.add(loginInfo);
		
		//3.) Send token to user/client/browser
		Cookie cookie=new Cookie("SECUREID",token);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		response.sendRedirect("/");
		
		return "Login Submitted!";
		
	}
	

}
