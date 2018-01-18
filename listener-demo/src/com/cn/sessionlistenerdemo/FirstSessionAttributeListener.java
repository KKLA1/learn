package com.cn.sessionlistenerdemo;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class FirstSessionAttributeListener implements HttpSessionAttributeListener {

	public FirstSessionAttributeListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("FirstSessionAttributeListener.attributeAdded...");

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("FirstSessionAttributeListener.attributeRemoved...");

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("FirstSessionAttributeListener.attributeReplaced...");

	}

}
