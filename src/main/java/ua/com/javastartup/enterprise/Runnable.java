package ua.com.javastartup.enterprise;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ua.com.javastartup.enterprise.person.model.Person;

public class Runnable {

	public static void main(String[] args) throws Exception {

		EntityManager em = DatabaseConfig.EMF.createEntityManager();
		System.out.println(em.getClass());
		try {
			TypedQuery<Person> q = em.createNamedQuery(
					"Person.findByName", Person.class);
			q.setParameter("pattern", "P%");
			System.out.println(q.getResultList());

		} finally {
			em.close();
			DatabaseConfig.EMF.close();
		}
	}

}
