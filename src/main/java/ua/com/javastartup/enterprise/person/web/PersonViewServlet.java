package ua.com.javastartup.enterprise.person.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.javastartup.enterprise.Context;
import ua.com.javastartup.enterprise.person.model.Person;
import ua.com.javastartup.enterprise.person.service.PersonService;

@SuppressWarnings("serial")
public class PersonViewServlet extends HttpServlet {

	PersonService service = Context.getInstance()
			.getBean(PersonService.class);

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {

		String idStr = request.getParameter("id");
		if (idStr == null) {
			List<Person> list = service.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/person/list.jsp")
					.forward(request, response);
		} else {
			Long id = Long.valueOf(idStr);
			Person person = service.findOne(id);
			request.setAttribute("person", person);
			request.getRequestDispatcher("/jsp/person/view.jsp")
					.forward(request, response);
		}
	}
}
