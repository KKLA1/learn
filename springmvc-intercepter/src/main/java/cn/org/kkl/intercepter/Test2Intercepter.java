package cn.org.kkl.intercepter;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class Test2Intercepter implements WebRequestInterceptor {

	@Override
	public void preHandle(WebRequest request) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		// TODO Auto-generated method stub

	}

}
