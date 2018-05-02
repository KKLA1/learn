package cn.org.kkl.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.toString());
		System.out.println("***preHandle*********preHandle****************preHandle*********");
		/*if(request.getSession().getAttribute("username")==null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return false;
		}*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		modelAndView.addObject("msg", "这是从拦截器中获得的msg");
		System.out.println("***postHandle*********postHandle****************postHandle*********");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("***afterCompletion*********afterCompletion****************afterCompletion*********");

	}

}
