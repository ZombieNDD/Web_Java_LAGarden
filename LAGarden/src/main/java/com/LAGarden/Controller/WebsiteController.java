package com.LAGarden.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class WebsiteController {
	@RequestMapping("/")
	public String index(ModelMap model) {
		model.addAttribute("", "Index");
		return "";
	}
}
