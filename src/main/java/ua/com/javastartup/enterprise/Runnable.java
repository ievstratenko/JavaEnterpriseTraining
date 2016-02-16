package ua.com.javastartup.enterprise;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import ua.com.javastartup.enterprise.person.dao.PersonDao;

public class Runnable {

	public static void main(String[] args) throws Exception {
		try (AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"appContext.xml")) {
			PersonDao dao = ac.getBean(PersonDao.class);
			Sort sort = new Sort(new Order(Direction.DESC, "age"),
					new Order(Direction.ASC, "id"));
			Pageable p = new PageRequest(1, 2, sort);
			System.out.println(dao.findAll(p).getContent());
			
		}
	}

}
