package com.cn.applicationlistenerdemo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class FirstServletContent implements ServletContextListener {


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String str=sce.getServletContext().getInitParameter("initParam");
		
		System.out.println("FirstServletContent.contextInitialized........"+str);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("FirstServletContent.contextDestroyed<end>");

	}

}
