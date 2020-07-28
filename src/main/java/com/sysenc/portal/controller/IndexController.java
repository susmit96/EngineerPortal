package com.sysenc.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysenc.portal.services.IndexService;
import com.sysenc.portal.view.IndexPostModel;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private IndexService indexService;

	@ModelAttribute("indexPostModel")
	IndexPostModel setupForm() {
		return new IndexPostModel();
	}

	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}

	@PostMapping("register/send")
	public String send(@Valid @ModelAttribute("indexPostModel")IndexPostModel indexPostModel,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "index";
		}
		indexService.insertRegisterInfo(indexPostModel);

		return "redirect:/";
	}

	@RequestMapping(value="register/complete",method=RequestMethod.GET)
	public String complete(Model model) {
		return "complete";
	}



}
