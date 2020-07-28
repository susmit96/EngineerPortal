package com.sysenc.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class engineerProfileController {

	@GetMapping("/engineerProfile/edit")
	public String edit(Model model) {
		return "engineerProfileEdit";
	}


}
