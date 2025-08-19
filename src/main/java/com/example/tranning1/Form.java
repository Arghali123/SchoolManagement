package com.example.tranning1;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Form {

	@GetMapping("/register")
	public String getForm()
	{
		return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Simple HTML-Only Form</title>
</head>
<body>
  <h1>Registration Form</h1>

  <form action="/save" method="get">
    <!-- Full Name -->
    <div>
      <label for="name">Full Name</label><br />
      <input type="text" id="name" name="name" placeholder="Enter your full name" required />
    </div>

    <!-- Email -->
    <div>
      <label for="email">Email</label><br />
      <input type="email" id="email" name="email" placeholder="Enter yout email" required />
    </div>
    
     <!-- Address -->
    <div>
      <label for="address">Address</label><br />
      <input type="text" id="address" name="address" placeholder="Enter your address" required />
    </div>

    <!-- Buttons -->
    <div>
      <button type="submit">Submit</button>
      
    </div>
  </form>
</body>
</html>

				""";
	}
	
	@GetMapping("/save")
	public String saveRegisterPage(@RequestParam("name") String fullName,@RequestParam("email")String Email,@RequestParam("address") String Address)
	{
		return 
				"<p>Name: "+fullName+"</p>"+"<br>"+
				"<p>Email: "+Email+"</p>"+"<br>"+
				"<p>Address: "+Address+"</p>"+"<br>";
	}
	
	
}
