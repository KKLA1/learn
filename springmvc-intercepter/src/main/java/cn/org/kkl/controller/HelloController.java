package cn.org.kkl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(value="/first",method=RequestMethod.POST)
	public String hello(HttpServletRequest request) {
		String username=(String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		System.out.println("*****************i am coming in**"+username+"****"+password+"******************");
		return "first";
	}
	
	@RequestMapping(value="/second")
	public void second(HttpServletRequest request) {
		String username=(String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		System.out.println("*****************i am coming in**"+username+"****"+password+"******************");
	}
	
	

}
