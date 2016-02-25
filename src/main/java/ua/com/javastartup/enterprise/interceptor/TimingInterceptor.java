package ua.com.javastartup.enterprise.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
					throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		System.out.println(handler.getClass());
		System.out.println(handler);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(modelAndView.getModel());
		long startTime = (Long) request.getAttribute("startTime");
		System.out.println(System.currentTimeMillis() - startTime);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			Exception ex) throws Exception {
		System.out.println("afterCompletion");
		throw new IllegalAccessException("wrong role");
	}

}
