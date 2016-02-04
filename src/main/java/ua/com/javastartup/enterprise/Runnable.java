package ua.com.javastartup.enterprise;

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
			person.address.add(new Address("Kyiv", "Gagarina"));
			person.address
					.add(new Address("Odessa", "Deribasovskaya"));
			person.phoneNumbers.put("Home", "+38068...");
			person.phoneNumbers.put("Work", "+38044...");
			em.getTransaction().begin();
//			em.persist(person);
			em.getTransaction().commit();
			TypedQuery<Person> q = em.createQuery("from Person",
					Person.class);
			System.out.println("1===");
			p = q.getResultList().get(0);
			System.out.println("2===");
			System.out.println(p);
			System.out.println("3==============");
			System.out.println(p.getPhoneNumbers());
			System.out.println(p.getPhoneNumbers().getClass());
		} finally {
			em.close();
			emf.close();
		}
	}

}
