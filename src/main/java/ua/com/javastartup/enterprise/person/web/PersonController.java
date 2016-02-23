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
public class PersonController {

	@Resource
	PersonService service;

	@RequestMapping(value = "person/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", service.findAll());
		return "person/list";
	}

	@RequestMapping(value = "person/view", method = RequestMethod.GET)
	public String view(@RequestParam("id") Long id, Model model) {
		model.addAttribute("person", service.findOne(id));
		return "person/view";
	}

	@RequestMapping(value = "person/add", method = RequestMethod.GET)
	public String addForm() {
		return "person/addForm";
	}

	@RequestMapping(value = "person/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("person") Person person) {
		service.save(person);
		return "redirect:/person/list";
	}

	@RequestMapping(value = "person/edit", method = RequestMethod.GET)
	public String editForm(@RequestParam("id") Long id, Model model) {
		model.addAttribute("person", service.findOne(id));
		return "person/editForm";
	}

	@RequestMapping(value = "person/edit",
			method = RequestMethod.POST)
	public String edit(@ModelAttribute("person") Person person) {
		service.save(person);
		return "redirect:/person/list";
	}

	@RequestMapping(value = "person/delete",
			method = RequestMethod.GET)
	public String view(@RequestParam("id") Long id) {
		service.delete(id);
		return "redirect:/person/list";
	}
}
