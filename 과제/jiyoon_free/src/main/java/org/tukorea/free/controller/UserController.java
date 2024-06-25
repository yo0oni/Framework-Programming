package org.tukorea.free.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home() {
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(String id, String password, Model model, HttpSession session) {
		boolean loginSuccess = userService.login(id, password);
		
		if (loginSuccess) {
			UserVO user = userService.selectById(id); 
			session.setAttribute("user", user);
			
			return "redirect:/schedules/home";
		} else {
			return "redirect:/users/home";
		}

	}
}
