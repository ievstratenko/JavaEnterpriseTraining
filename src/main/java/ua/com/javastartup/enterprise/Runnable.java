package ua.com.javastartup.enterprise;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.javastartup.enterprise.person.dao.PersonDao;
import ua.com.javastartup.enterprise.person.dao.PersonDaoImpl;
import ua.com.javastartup.enterprise.person.dao.PersonDaoTestImpl;
import ua.com.javastartup.enterprise.person.model.Person;
import ua.com.javastartup.enterprise.person.service.PersonService;
import ua.com.javastartup.enterprise.person.service.PersonServiceImpl;

public class Runnable {

	public static void main(String[] args) throws Exception {
		boolean test = false;
		PersonDao dao;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		if (test) {
			dao = new PersonDaoTestImpl();
		} else {
			emf = Persistence.createEntityManagerFactory("emf");
			em = emf.createEntityManager();
			dao = PersonDaoImpl.getInstance(em);
		}
		PersonService service = new PersonServiceImpl(dao);
		try {
			service.save(new Person("Sara"));
			System.out.println(service.findById(1L));
		} finally {
			if (!test) {
				em.close();
				emf.close();
			}
		}
	}

}
