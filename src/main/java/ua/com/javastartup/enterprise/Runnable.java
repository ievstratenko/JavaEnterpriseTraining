package ua.com.javastartup.enterprise;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.javastartup.enterprise.person.dao.PersonDao;

public class Runnable {

	public static void main(String[] args) throws Exception {
		try (AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"appContext.xml")) {
			PersonDao dao = ac.getBean(PersonDao.class);
			// service.save(new Person("Ivan"));
			System.out.println(dao.setNewName("Ivan", "John"));
		}
	}

}
