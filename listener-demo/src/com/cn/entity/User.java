package com.cn.entity;

public class User {

	public User() {
		
	}
	
	private String sessionidstring;
	
	private String ipstring;
	
	private String firstTime;

	public String getSessionidstring() {
		return sessionidstring;
	}

	public void setSessionidstring(String sessionidstring) {
		this.sessionidstring = sessionidstring;
	}

	public String getIpstring() {
		return ipstring;
	}

	public void setIpstring(String ipstring) {
		this.ipstring = ipstring;
	}

	public String getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}

}
