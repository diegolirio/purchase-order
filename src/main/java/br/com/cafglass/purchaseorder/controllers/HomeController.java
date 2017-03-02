package br.com.cafglass.purchaseorder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("")
	public String index() {
		return "index";
	}

	@RequestMapping("app")
	public String app() {
		return "dist/index";
	}
}
