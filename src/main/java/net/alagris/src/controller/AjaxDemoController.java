package net.alagris.src.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxDemoController {

	@RequestMapping("/ajax_demo.html")
	public String demo() {
		return "ajax_demo";
	}

	@RequestMapping(value = "/ajax_demo_submit.htm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String Submit(@RequestParam Map<String, String> allRequestParams) {
		return "responce";
	}
}
