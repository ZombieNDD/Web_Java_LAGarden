package com.LAGarden.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class WebsiteController {
	@RequestMapping("/")
	public String home(ModelMap model) {
		System.out.print("Hello");
		return "home";
	}
}
