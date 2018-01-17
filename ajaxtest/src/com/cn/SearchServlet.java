package com.cn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class SearchServlet extends HttpServlet {
	static List<String> datas = new ArrayList<String>();
	
	static{
		datas = new ArrayList<String>();
		datas.add("ajax");
		datas.add("ajax post");
		datas.add("backy");
		datas.add("bill");
		datas.add("janes");
		datas.add("jerry");
		datas.add("please import");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5036886699325184914L;
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		//获取关键字
		String keyword = req.getParameter("keyword");
		PrintWriter pw =res.getWriter();
		List<String> listData;
		if(null!=keyword && !"".equals(keyword)){
			listData = getData(keyword);
			//list转化成json
		}else{
			keyword="please";
			listData = getData(keyword);
			
		}
		pw.write(JSONArray.fromObject(listData).toString());
		pw.flush();
		pw.close();
	}
	
	public List<String> getData(String keyword){
		List<String> list = new ArrayList<String>();
		for(String str:datas){
			if(str.contains(keyword)){
				list.add(str);
			}
		}
		return list;
	}

	

}
