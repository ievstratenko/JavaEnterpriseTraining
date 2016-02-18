package ua.com.javastartup.enterprise.person.web;

import javax.servlet.http.HttpServlet;

import ua.com.javastartup.enterprise.Context;
import ua.com.javastartup.enterprise.person.service.PersonService;

@SuppressWarnings("serial")
public abstract class PersonBaseServlet extends HttpServlet {

	PersonService service = Context.getInstance()
			.getBean(PersonService.class);
}
