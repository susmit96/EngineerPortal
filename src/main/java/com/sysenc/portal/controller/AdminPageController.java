package com.sysenc.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysenc.portal.model.EngineerInformation;
import com.sysenc.portal.services.EngineerInformationService;
import com.sysenc.portal.view.EngineerInformationViewModel;

@Controller
public class AdminPageController {

	@Autowired
	private EngineerInformationService engineerInformationService;

	@ModelAttribute("viewModel")
	EngineerInformationViewModel setUpViewModel() {
		return new EngineerInformationViewModel();
	}

	protected <T> String viewModel(T viewModel, Model model, String viewName) {
		model.addAttribute("viewModel",viewModel);
		return viewName;
	}

//	@GetMapping("/adminPage")
//	public String admin(@ModelAttribute("engineerInformationViewModel")EngineerInformationViewModel engineerInformationViewModel,Model model) {
//		String fullName = null;
//		String address = null;
//		String comment = null;
//		return listByPage(1, fullName,address, comment, engineerInformationViewModel, model);
//	}

	@GetMapping("/adminPage")
	public String admin(@ModelAttribute("engineerInformationViewModel")EngineerInformationViewModel engineerInformationViewModel,Model model) {
		String fullName = null;
		String address = null;
		return listByPage(1, fullName, address,engineerInformationViewModel, model);
	}
//	@GetMapping("/page/{pageNumber}")
//	public String listByPage(@PathVariable("pageNumber") int pageNumber,
//							 @Param("fullName") String fullName,
//							 @Param("address") String address,
//							 @Param("comment") String comment,
//			                 @ModelAttribute("engineerInformationViewModel")EngineerInformationViewModel engineerInformationViewModel,Model model) {
//		Page<EngineerInformation> page = engineerInformationService.initView(pageNumber,fullName,address,comment);
//		long totalItems = page.getTotalElements();
//		int totalPages = page.getTotalPages();
//		List<EngineerInformation> ei = page.getContent();
//		model.addAttribute("totalItems",totalItems);
//		model.addAttribute("totalPages",totalPages);
//		engineerInformationViewModel.setEngineerInfoList(ei);
//		return "adminPage";
//	}


	@GetMapping("/page/{pageNumber}")
	public String listByPage(@PathVariable("pageNumber") int pageNumber,
							 @Param("fullName") String fullName,
							 @Param("address")String address,
			                 @ModelAttribute("engineerInformationViewModel")EngineerInformationViewModel engineerInformationViewModel,Model model) {
		Page<EngineerInformation> page = engineerInformationService.initView(pageNumber,fullName,address);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<EngineerInformation> ei = page.getContent();
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("totalPages",totalPages);
		engineerInformationViewModel.setEngineerInfoList(ei);
		return "adminPage";
	}


    @RequestMapping(value="/engineerProfile/engineerId={engineerId}",method = RequestMethod.GET)
    public String getProfile(@PathVariable("engineerId") String engineerId,
    						 @ModelAttribute("engineerInformationViewModel")EngineerInformationViewModel engineerInformationViewModel,
    						 Model model) {
    	engineerInformationViewModel.setEngineerId(engineerId);
    	engineerInformationService.show(engineerInformationViewModel);
    	return "engineerProfile";

    }

//    @GetMapping("/adminPage/fullName={fullName}&address={address}&comment={comment}")
//    public String getSearchedPage(@Param("fullName") String fullName,
//    							  @Param("address") String address,
//    							  @Param("comment") String comment,
//    		                      @ModelAttribute("engineerInformationViewModel") EngineerInformationViewModel engineerInformationViewModel,
//    		                      Model model) {
//    	engineerInformationViewModel.setName(fullName);
//    	engineerInformationViewModel.setAddress(address);
//    	engineerInformationViewModel.setComment(comment);
//    	engineerInformationService.search(engineerInformationViewModel);
//    	return "adminPage";
//    }

}