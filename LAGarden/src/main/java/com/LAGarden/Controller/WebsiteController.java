package com.LAGarden.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class WebsiteController {
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "home";
	}
	
	@RequestMapping("/tintuc")
    public String tintuc(ModelMap model)
    {
        return "tintuc";
    }
	
}
