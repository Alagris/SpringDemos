package net.alagris.src.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DemoUploadController {

    @Autowired
    File persistentDir;

    @RequestMapping(value = "/demo_upload", method = RequestMethod.GET)
    public String handleFileUpload(Model model) {
	if (!model.containsAttribute("message")) {
	    model.addAttribute("message", "Pleas select file");
	}
	model.addAttribute("files", persistentDir.list());
	return "demo_upload";
    }

    @RequestMapping(value = "/demo_upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
	try {
	    file.transferTo(new File(persistentDir, file.getOriginalFilename()));
	} catch (IllegalStateException | IOException e) {
	    redirectAttributes.addFlashAttribute("message", e.getMessage());
	}
	return "redirect:/demo_upload";
    }
}
