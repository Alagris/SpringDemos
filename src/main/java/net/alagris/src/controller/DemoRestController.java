package net.alagris.src.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	public class ResponceBody {
		private String responce = "default";
		private int responceCode = -1;

		public ResponceBody() {
		}

		public int getResponceCode() {
			return responceCode;
		}

		public void setResponceCode(int responceCode) {
			this.responceCode = responceCode;
		}

		public String getResponce() {
			return responce;
		}

		public void setResponce(String responce) {
			this.responce = responce;
		}

	}

	@RequestMapping("/demo-rest")
	public ResponceBody demo() {
		return new ResponceBody();
	}

	/**
	 * unlike {@link IndexController#index()} this method won't return page but
	 * rather a string
	 */
	@RequestMapping("/demo-rest-fake-page")
	public String demoFake() {
		return "index";
	}

	@RequestMapping(value = "/demo1-rest", params = { "re" })
	public ResponceBody demo1(@RequestParam("re") String responce) {
		ResponceBody r = new ResponceBody();
		r.setResponce(responce);
		return r;
	}

	@RequestMapping(value = "/demo1-rest", params = { "c" })
	public ResponceBody demo1(@RequestParam("c") int code) {
		ResponceBody r = new ResponceBody();
		r.setResponceCode(code);
		return r;
	}

	@RequestMapping(value = "/demo1-rest", params = { "re", "c" })
	public ResponceBody demo1(@RequestParam("re") String responce, @RequestParam("c") int code) {
		ResponceBody r = new ResponceBody();
		r.setResponce(responce);
		r.setResponceCode(code);
		return r;
	}

}
