package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	 @Autowired private UserService userService;  
	 
	 @RequestMapping({"/", "/home"})  
	  public String home(Model model) {  
		 List<User> users =  userService.getAllUser();
	   model.addAttribute("users", users);  
	    return "home";  
	  }  
	
	 @RequestMapping(value = "add")  
	  public String addUser(Model model) {  
	    model.addAttribute("user", new User());  
	    return "addUser";  
	  }  
	 
	  @RequestMapping(value = "save", method = RequestMethod.POST)  
	  public String save(User user, Model model) {  
	    userService.saveUser(user);  
	    List<User> users =  userService.getAllUser();
		 model.addAttribute("users", users);  
	    return "home";  
	  }  
	  
	  @RequestMapping(value = "/edit", method = RequestMethod.GET)  
	  public String editUser(@RequestParam("id") Integer userId, Model model) {  
	    Optional<User> userEdit = userService.findUserById(userId);  
	    userEdit.ifPresent(user -> model.addAttribute("user", user));  
	    return "editUser";  
	  }   
	  
	  @RequestMapping(value = "delete", method = RequestMethod.GET)  
	  public String delete(User user, Model model) {  
	    userService.deleteUser(user.getId());
	    List<User> users =  userService.getAllUser();
		 model.addAttribute("users", users);  
	    return "home";  
	  }  

}
