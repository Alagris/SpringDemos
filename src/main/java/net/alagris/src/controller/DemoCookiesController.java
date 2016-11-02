package net.alagris.src.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoCookiesController {

    @RequestMapping(value = "/demo_cookies.html", method = RequestMethod.GET)
    public ModelAndView demo3(@CookieValue(value = "foo", defaultValue = "hello") String fooCookie, ModelMap model,
	    HttpServletResponse response) {
	model.addAttribute("foo", fooCookie);
	response.addCookie(new Cookie("foo2", fooCookie));
	// cookies foo and foo2 expire at the end of session
	return new ModelAndView("demo_cookies", model);
    }
}
