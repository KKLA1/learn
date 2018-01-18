package com.cn.applicationlistenerdemo;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FirstServetContextAttributeListener implements ServletContextAttributeListener {

	public FirstServetContextAttributeListener() {
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("FirstServetContextAttributeListener.attributeAdded...");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("FirstServetContextAttributeListener.attributeRemoved...");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("FirstServetContextAttributeListener.attributeReplaced...");
	}

}
