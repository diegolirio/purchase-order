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
@RequestMapping("/user/login")
public class UserLoginController {

	@Autowired
	private UserService userService;

	/**
	 * Efetuar Login
	 * @param usuario
	 * @param session 
	 * @return Response (JSON)
	 */
	@RequestMapping(value="", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> efetuarLogin(@RequestBody User user, HttpSession session) {
		try {
			session.setAttribute("userLogged", user);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(user), HttpStatus.OK);
		} catch(Exception e ) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Efetuar Login
	 * @param usuario
	 * @param session 
	 * @return Response (JSON)
	 */
	@RequestMapping(value="/temp", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> efetuarLoginTemp(User user, HttpSession session) {
		try {
			user = this.userService.login(user.getLogin(), user.getPassword());
			if (user == null) 
				return new ResponseEntity<String>("Usuario ou senha incorreto", HttpStatus.UNAUTHORIZED);
			session.setAttribute("userLogged", user);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(user), HttpStatus.OK);
		} catch(Exception e ) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Verifica se ha sessao(logado) do usuario
	 * @param session
	 * @return restFull JSON usuario
	 */
	@RequestMapping(value="/session", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getSessionLogged(HttpSession session) {
		try {
			User user = (User) session.getAttribute("userLogged");
			if(user == null) 
				throw new RuntimeException("Usuario desconectado");
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(user), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}	
	
	/*
	 * Sair da sessao
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> logout(HttpSession session) {
		try {
			session.invalidate();
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
}
