package cn.org.kkl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TestController {

	@RequestMapping("/viewall")
	public ModelAndView viewAll(String username,String password) {
		ModelAndView mv= new ModelAndView();
		System.out.println("********进入了viewall方法**********");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		mv.addObject("msg", "*****从controller 的viewall方法中设置的msg**********");
		mv.setViewName("hello1");
		return mv;
	}
}
