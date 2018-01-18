package com.cn.requestlistenerdeml;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.cn.entity.User;
import com.cn.utils.SessionUtil;
@WebListener
public class FirstRequestListener implements ServletRequestListener {
	
	private ArrayList<User> userlist;//在线用户list

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest req =(HttpServletRequest)sre.getServletRequest();
		req.getLocalPort();
		System.out.println("requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		
		userlist=(ArrayList<User>)sre.getServletContext().getAttribute("userlist");
		
		if(userlist==null){
			userlist = new ArrayList<User>();
		}
		
		HttpServletRequest req =(HttpServletRequest)sre.getServletRequest();
		String sessionid = req.getSession().getId();
		if(SessionUtil.getUserById(userlist,sessionid)==null){
			User user = new User();
			user.setSessionidstring(sessionid);
			user.setIpstring(req.getRemoteAddr());
			user.setFirstTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			userlist.add(user);
		}
		sre.getServletContext().setAttribute("userlist", userlist);
		System.out.println("requestInitialized");
	}

	

}
