package com.diegolirio.purchaseorder.controllers;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.purchaseorder.models.User;
import com.diegolirio.purchaseorder.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/profile")
	public String pageProfile() {
		return "user/profile";
	}

	/*
	 * Rest
	 */
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody User user) {
		try {
			this.userService.save(user);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(user), HttpStatus.CREATED);
		} catch(Exception e ) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/save/my/user/params", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> saveParamsMyUser(User user, HttpSession session) {
		try {
			User userSave = this.userService.get(user.getId());
			userSave.setName(user.getName());
			userSave.setEmail(user.getEmail());
			userSave.setLogin(user.getLogin());
			userSave.setCnpj(user.getCnpj());
			user = this.userService.save(userSave);
			session.setAttribute("userLogged", user);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(user), HttpStatus.CREATED);
		} catch(Exception e ) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
