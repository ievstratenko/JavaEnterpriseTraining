package ua.com.javastartup.enterprise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.javastartup.enterprise.person.model.Person;
import ua.com.javastartup.enterprise.person.service.PersonService;

public class Runnable {

	public static void main(String[] args) throws Exception {
		boolean test = false;
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"appContext.xml");
		
		PersonService service = ac.getBean(PersonService.class);
		try {
			service.save(new Person("Ivan"));
			System.out.println(service.findById(1L));
		} finally {
			((AbstractApplicationContext) ac).close();
		}
	}

}
