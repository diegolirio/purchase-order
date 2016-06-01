package com.diegolirio.purchaseorder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("settings")
public class SettingsController {

	@RequestMapping(value="")
	public String settings() {
		return "settings";
	}
	 
}
