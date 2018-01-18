package com.cn.entity;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Student implements HttpSessionBindingListener,Serializable,HttpSessionActivationListener {

	public Student() {}
	
	private String name;
	
	private int age;
	
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("valueBound name"+arg0.getName());

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("valueUnbound name"+arg0.getName());

	}

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("sessionDidActivate:"+arg0.getSource());
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("sessionWillPassivate: "+arg0.getSource());
		
	}

}
