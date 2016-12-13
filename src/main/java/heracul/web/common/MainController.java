package heracul.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public ModelAndView  defaultPage() {
		ModelAndView mav = new ModelAndView("welcome.jsp");
		mav.addObject("name", "SEIL");
		return mav;
	}

	@RequestMapping("/main.do")
	public ModelAndView mainPage() {
		ModelAndView mav = new ModelAndView("main.jsp");
		mav.addObject("name", "SEIL");
		mav.addObject("xmp", "What the hell");
		return mav;
	}
	
	@RequestMapping("/bootstrapDemo.do")
	public ModelAndView demoBoot() {
		ModelAndView mav = new ModelAndView("jsp/bootstrapSample.jsp");
		return mav;
	}
}
