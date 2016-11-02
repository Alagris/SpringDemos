package net.alagris.src.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafDemosController {

	@RequestMapping("/thymeleaf_javascript_demo_fake.html")
	public String nonExistentPage() {
		return "/thymeleaf_javascript_demo.html";// notice the .html changes
													// everything
	}

	@RequestMapping("/thymeleaf_javascript_demo.html")
	public String javascriptDemo() {
		return "/thymeleaf_javascript_demo";
	}
}
