package ua.com.javastartup.enterprise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class JspServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {

		String testParam = request.getParameter("testParam");
		System.out.println("=== testParam : " + testParam);
		request.setAttribute("testParam", testParam);
		request.getRequestDispatcher("/jsp/test.jsp").forward(request,
				response);
	}
}
