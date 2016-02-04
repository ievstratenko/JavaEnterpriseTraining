package ua.com.javastartup.enterprise;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runnable {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("emf");
		EntityManager em = emf.createEntityManager();
		try {
			Person person = new Student("Ivan", "Math");
			person.address = new Address("Kyiv", "Gagarina");
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
		} finally {
			em.close();
			emf.close();
		}
	}

}
