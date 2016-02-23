package ua.com.javastartup.enterprise.person.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.javastartup.enterprise.person.model.Person;
import ua.com.javastartup.enterprise.person.service.PersonService;

@Controller
@RequestMapping("person")
public class PersonController {

	@Resource
	PersonService service;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", service.findAll());
		return "person/list";
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view() {
		return "person/view";
	}

	@RequestMapping(value = { "add", "edit" },
			method = RequestMethod.GET)
	public String form() {
		return "person/form";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("person") Person person) {
		service.save(person);
		return "redirect:/person/list";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@RequestParam("id") Long id) {
		service.delete(id);
		return "redirect:/person/list";
	}

	@ModelAttribute("person")
	public Person getPerson(
			@RequestParam(value = "id", required = false) Long id) {
		return id == null ? new Person() : service.findOne(id);
	}
}
