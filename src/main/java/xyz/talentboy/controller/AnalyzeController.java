package xyz.talentboy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.talentboy.service.ICommonService;

@Controller
public class AnalyzeController {
	
	private static final Logger logger = LoggerFactory.getLogger(AnalyzeController.class);
	
	@Autowired
	ICommonService commonService;
	
	@RequestMapping("/combine")
	public String combineSalesAndCustomer(ModelAndView view){
		logger.info("combine组合");
		commonService.combineSalesAndCustomer();
		return "redirect:/";
	}
	
	
}
