package ua.com.javastartup.enterprise;

import javax.persistence.EntityManager;

import ua.com.javastartup.enterprise.person.dao.PersonDao;
import ua.com.javastartup.enterprise.person.model.Person;

public class Runnable {

	public static void main(String[] args) {

		EntityManager em = DatabaseConfig.EMF.createEntityManager();
		PersonDao personDao = new PersonDao(em);
		Person p = null;
		try {
			Person person = new Person("Tom");
			
			personDao.save(person);

			p = personDao.findById(1L);
			System.out.println(p);
		} finally {
			em.close();
			DatabaseConfig.EMF.close();
		}
	}

}
