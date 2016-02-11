package ua.com.javastartup.enterprise;

import javax.persistence.EntityManager;

import ua.com.javastartup.enterprise.person.dao.PersonDao;
import ua.com.javastartup.enterprise.person.model.Person;

public class Runnable {

	public static void main(String[] args) throws Exception {

		EntityManager em = DatabaseConfig.EMF.createEntityManager();
		PersonDao personDao = new PersonDao(em);
		try {
			personDao.save(new Person("Taras"));
			System.out.println(personDao.findById(1L));
		} finally {
			em.close();
			DatabaseConfig.EMF.close();
		}
	}

}
