package com.skilldistillery.booknerds.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.booknerds.entities.User;
import com.skilldistillery.booknerds.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class UserController {
	
	@Autowired
	private UserService userSvc;

	@PutMapping("profile")
	public User update(
			@RequestBody User user,
			HttpServletResponse res,
			Principal principal
	) {
		if (principal == null) {
			res.setStatus(401);
			return null;
		}
		try {
			user = userSvc.updateUser(principal.getName(), user);
			if (user == null) {
				res.setStatus(404);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return null;
		}
		return user;
	}
}
