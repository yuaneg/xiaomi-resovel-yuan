package xyz.talentboy.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yuaneg 2017年1月17日上午10:38:51
 *
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/")
	public ModelAndView indexCon(ModelAndView view,String validate) {
		logger.info("访问时间" + new Date());
		view.setViewName("home");
		if(null == validate){
			view.addObject("validate", "success");
		} else {
			view.addObject("validate", validate);
		}
		return view;
	}
	
	
}
