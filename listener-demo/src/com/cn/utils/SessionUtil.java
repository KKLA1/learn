package com.cn.utils;

import java.util.ArrayList;

import com.cn.entity.User;

public class SessionUtil {

	public SessionUtil() {
		
	}

	public static Object getUserById(ArrayList<User> userlist,String sessionid) {
		for(int i=0;i<userlist.size();i++){
			User user=userlist.get(i);
			if(sessionid.equals(user.getSessionidstring())){
				return user;
			}
		}
		return null;
	}
}
