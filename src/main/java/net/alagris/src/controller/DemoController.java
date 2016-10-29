package net.alagris.src.controller;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

//notice difference between @Controller and @RestController
//@RestController will return JSON objects
//@Controller will return HTML files
@Controller
public class DemoController {

    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/demo")
    public String demo(){
    	return "demo";
    }
    
    @RequestMapping(value = "/demo/{path:.+}",method=RequestMethod.GET)//simple version=> @RequestMapping(value="/demo")
    public ModelAndView demo1(@PathVariable("path") String detailedPath,@RequestParam Map<String,String> allRequestParams,ModelMap model) {
    	model.addAttribute("mapped_method", "demo1");
    	model.addAttribute("requests_sent_so_far", counter.incrementAndGet());
    	model.addAttribute("request_parameters",allRequestParams);
    	model.addAttribute("request_path",detailedPath);
    	return new ModelAndView("demo",model);
    }
    
    @RequestMapping(value = "/demo/{path:.+}/**",method=RequestMethod.GET)//simple version=> @RequestMapping(value="/demo")
    public ModelAndView demo2(@PathVariable("path") String detailedPath,@RequestParam Map<String,String> allRequestParams,ModelMap model,HttpServletRequest request) {
    	model.addAttribute("mapped_method", "demo2");
    	model.addAttribute("requests_sent_so_far", counter.incrementAndGet());
    	model.addAttribute("request_parameters",allRequestParams);
    	model.addAttribute("request_path",detailedPath);
    	model.addAttribute("full_path", request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
    	return new ModelAndView("demo",model);
    }

    
    @RequestMapping(value = "/demo-ajax.htm", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String Submit(@RequestParam Map<String,String> allRequestParams) {
        return "responce";
    }
}

