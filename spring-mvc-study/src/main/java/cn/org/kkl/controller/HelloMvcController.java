package cn.org.kkl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {

	
	/**
	 * url=
	 * ${pageContext.request.contextPath}/hello/mvc
	 */
	@RequestMapping("/mvc")
	public String helloMvc() {
		System.out.println("***************我已经来过了***************");
		return "home";
	}
}
