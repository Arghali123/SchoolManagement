package com.example.tranning1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ShoppingController {
	List<ShoppingItem> shoppingList=new ArrayList<>();
	
	@GetMapping("/shopping/list/{user}")
	public String getShowShoppingListPage(@PathVariable("user") String user)
	{
		String result="<h1>Hello world, "+user+"!</h1>";
	    result+="<p>My shopping List:</p>";
		if(shoppingList.isEmpty())
		{
			result = result + "<p><b>No items</b></p>";
		}else
		{
			result=result+"<ul>";
			for(int i=0;i<shoppingList.size();i++)
			{
				if(shoppingList.get(i).getUser().equals(user))
				{
					result = result + "<li><span>" + shoppingList.get(i).getItem() + "</span>"
							+ "<a href=\"/shopping/delete/" + i + "\"> Remove </a>" + "</li>";
				}
			}
			result+="</ul>";
		}
		result = result + """
		        <form action="/shopping/save" method="get">
		            <input type="text" placeholder="Item" name="item" />
		            <input type="hidden" name="user"
		            
				"""+"value=\""+user+"\" />"+
				"""
		            <input type="submit" value="ADD ITEM" />
		        </form>
		        """;

		System.out.println(result); // print raw HTML
		return result;
		
	}
	
	@GetMapping("/shopping/save")
	public String saveNewShoppingItem(@RequestParam("item") String item, @RequestParam("user") String user,
			HttpServletResponse resp) throws IOException {
		shoppingList.add(new ShoppingItem(item, user));
		resp.sendRedirect("/shopping/list/"+user); // browser goes to this url
		return "Item added!";
	}
	
	@GetMapping("/shopping/delete/{index}")
	public String deleteShoppingItem(@PathVariable("index") int index,HttpServletResponse resp)throws IOException
	{
		String user="";
		if(index<shoppingList.size())
		{
			shoppingList.remove(index);
			user=shoppingList.get(index).getUser();
		}
		resp.sendRedirect("/shopping/list/"+user);
		return "Item Deleleted";
	}
}
