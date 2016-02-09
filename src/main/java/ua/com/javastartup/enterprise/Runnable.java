package ua.com.javastartup.enterprise;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.com.javastartup.enterprise.person.model.Person;

public class Runnable {

	public static void main(String[] args) throws Exception {

		EntityManager em = DatabaseConfig.EMF.createEntityManager();
		System.out.println(em.getClass());
		try {
			Query q = em.createNativeQuery("select id, name from PerSON",
					Person.class);
			System.out.println(q.getResultList());

		} finally {
			em.close();
			DatabaseConfig.EMF.close();
		}
	}

}
