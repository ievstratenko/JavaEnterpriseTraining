package ua.com.javastartup.enterprise.person.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	@RequestMapping
	public String view() {
		return "jsp/person/list.jsp";
	}
}
