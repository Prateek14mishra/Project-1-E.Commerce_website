package com.onlineShoping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = {"/","/home","/index"})
	public String myrootPage()
	{
		return "index";
	}
}
