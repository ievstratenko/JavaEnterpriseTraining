package ua.com.javastartup.enterprise;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.javastartup.enterprise.person.service.PersonService;

public class Runnable {

	public static void main(String[] args) throws Exception {
		try (AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"testContext.xml")) {
			PersonService service = ac.getBean(PersonService.class);
			System.out.println(service.findAll());			
		}
	}

}
