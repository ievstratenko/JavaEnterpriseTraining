package ua.com.javastartup.enterprise.person.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.javastartup.enterprise.Context;
import ua.com.javastartup.enterprise.person.model.Person;
import ua.com.javastartup.enterprise.person.service.PersonService;

@SuppressWarnings("serial")
public class PersonAddServlet extends PersonBaseServlet {

	PersonService service = Context.getInstance()
			.getBean(PersonService.class);

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {

		request.getRequestDispatcher("/jsp/person/addForm.jsp")
				.forward(request, response);
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {
		Person person = new Person();
		person.setName(request.getParameter("name"));
		person.setAge(Integer.valueOf(request.getParameter("age")));
		person = service.save(person);
		request.setAttribute("person", person);
		request.getRequestDispatcher("/jsp/person/view.jsp")
				.forward(request, response);
	}
}
