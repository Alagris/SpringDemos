package net.alagris.src.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

//notice difference between @Controller and @RestController
//@RestController will return JSON objects
//@Controller will return HTML files
@Controller
public class DemoController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/demo")
    public String demo() {
	return "demo";
    }

    @RequestMapping(value = "/demo/{path:.+}", method = RequestMethod.GET)
    public ModelAndView demo1(@PathVariable("path") String detailedPath,
	    @RequestParam Map<String, String> allRequestParams, ModelMap model) {
	model.addAttribute("mapped_method", "demo1");
	model.addAttribute("requests_sent_so_far", counter.incrementAndGet());
	model.addAttribute("request_parameters", allRequestParams);
	model.addAttribute("request_path", detailedPath);
	return new ModelAndView("demo", model);
    }

    @RequestMapping(value = "/demo/{path1}/{path2}", method = RequestMethod.GET)
    public ModelAndView demo2(@PathVariable("path1") String p1, @PathVariable("path2") String p2, ModelMap model) {
	model.addAttribute("mapped_method", "demo2");
	model.addAttribute("requests_sent_so_far", counter.incrementAndGet());
	model.addAttribute("request_path", p1 + "/" + p2);
	return new ModelAndView("demo", model);
    }

    @RequestMapping(value = "/demo/{path:.+}/**", method = RequestMethod.GET)
    public ModelAndView demo3(@PathVariable("path") String detailedPath,
	    @RequestParam Map<String, String> allRequestParams, ModelMap model, HttpServletRequest request) {
	model.addAttribute("mapped_method", "demo3");
	model.addAttribute("requests_sent_so_far", counter.incrementAndGet());
	model.addAttribute("request_parameters", allRequestParams);
	model.addAttribute("request_path", detailedPath);
	model.addAttribute("full_path", request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
	return new ModelAndView("demo", model);
    }

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value = "/demo_void.html", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK) // this annotation is the key for
					   // void controllers
    public void demo4() {
	log.info("Okay buddy. There is nothing in here for you.");
    }
}
