package cn.org.kkl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(value="/first",method=RequestMethod.GET)
	public String hello() {
		System.out.println("*****************i am coming in************************");
		return "first";
	}
	
	

}
