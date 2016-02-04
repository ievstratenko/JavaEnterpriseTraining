package ua.com.javastartup.enterprise;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Runnable {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("emf");
		EntityManager em = emf.createEntityManager();
		Person p = null;
		try {
			Person person = new Person("Ivan");
			Person person2 = new Person("Vera");
			List<Address> address = new ArrayList<>();			
			address.add(new Address("Kyiv", "Gagarina"));
			address.add(new Address("Odessa", "Deribasovskaya"));
			person.setAddress(address);
			List<Address> address2 = new ArrayList<>();			
			address2.add(address.get(0));
			address2.add(new Address("Lviv", "Svoboda"));
			person2.setAddress(address2);
			
			
			
			em.getTransaction().begin();
			em.persist(person);
			em.persist(person2);
			em.getTransaction().commit();
			
			TypedQuery<Person> q = em.createQuery("from Person",
					Person.class);
			p = q.getResultList().get(0);
			System.out.println(p);
			System.out.println(p.getAddress());			
			
		} finally {
			em.close();
			emf.close();
		}
	}

}
