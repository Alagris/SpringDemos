package net.alagris.src.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DemoRedirectController {

    @RequestMapping("/redirect_to_demo_controller.html")
    String redirect() {
	return "redirect:/demo";
    }

    @RequestMapping("/redirect_to_demo_controller/{path}")
    String redirect(@PathVariable("path") String path, RedirectAttributes redirectAttributes) {
	redirectAttributes.addAttribute("full_path", "You have been redirected!");
	return "redirect:/demo/" + path;
    }
}
