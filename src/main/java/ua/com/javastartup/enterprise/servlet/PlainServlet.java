package ua.com.javastartup.enterprise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PlainServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {

		response.getWriter().print("<h1>Hello New Servlet</h1>");
	}
}
