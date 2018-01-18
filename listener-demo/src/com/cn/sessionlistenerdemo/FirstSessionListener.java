package com.cn.sessionlistenerdemo;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.cn.entity.User;
import com.cn.utils.SessionUtil;
@WebListener
public class FirstSessionListener implements HttpSessionListener {
	
	private int usernumber=0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		se.getSession().getId();
		se.getSession().getCreationTime();
		usernumber++;
		se.getSession().getServletContext().setAttribute("usernumber", usernumber);//��������������Ӧ����������
		System.out.println("sessionCreated");
		

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		usernumber--;
		ArrayList<User> userlist = (ArrayList<User>)se.getSession().getServletContext().getAttribute("userlist");
		se.getSession().getServletContext().setAttribute("usernumber", usernumber);//��ȫ��webӦ���ж�����ȡ����ֵ
		
		if(SessionUtil.getUserById(userlist, se.getSession().getId())!=null){
			userlist.remove(SessionUtil.getUserById(userlist, se.getSession().getId()));
		}
		System.out.println("sessionDestroyed");
	}

}
