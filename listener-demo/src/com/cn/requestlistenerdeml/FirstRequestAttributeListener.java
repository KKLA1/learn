package com.cn.requestlistenerdeml;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class FirstRequestAttributeListener implements ServletRequestAttributeListener {

	public FirstRequestAttributeListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("FirstRequestAttributeListener.attributeAdded....");

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("FirstRequestAttributeListener.attributeRemoved....");

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("FirstRequestAttributeListener.attributeReplaced....");

	}

}
