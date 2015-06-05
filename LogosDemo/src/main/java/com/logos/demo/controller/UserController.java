package com.logos.demo.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.logos.demo.model.User;
import com.logos.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Inject
	private UserService userService;

	@RequestMapping()
	public ModelAndView getUsers(ModelAndView model) {

		model.addObject("usersList", userService.getAllUsers());
		model.setViewName("users");

		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUserById(Model model, @PathVariable long id) {
		
		User user = userService.getUserInfo(id);

		model.addAttribute("userInfo", user);

		return "user";
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public String getUserByName(Model model, @PathVariable String name) {

		model.addAttribute("userInfo", userService.getUserInfoByName(name));

		return "user";
	}

	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public String getUserByEmail(Model model, @PathVariable String email) {

		model.addAttribute("userInfo", userService.getUserInfoByEmail(email));

		return "user";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@RequestParam String email,
			@RequestParam String userName, @RequestParam String password) {

		userService.saveUser(userName, email, password);

		return "redirect:/users";
		
	}

}
