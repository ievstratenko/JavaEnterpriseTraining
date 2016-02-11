package ua.com.javastartup.enterprise.person.dao;

import javax.persistence.EntityManager;

import ua.com.javastartup.enterprise.person.model.Person;

public class PersonDaoImpl implements PersonDao {

	private static PersonDao instance;
	
	EntityManager em;

	private PersonDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public static PersonDao getInstance(EntityManager em) {
		if (instance == null) {			
			instance = new PersonDaoImpl(em);
		}
		return instance;
	}

	@Override
	public Person findById(Long id) {
		return em.find(Person.class, id);
	}

	@Override
	public void save(Person person) {
		em.getTransaction().begin();
		try {
			em.persist(person);
			em.getTransaction().commit();
		} catch (Throwable t) {
			em.getTransaction().rollback();
			System.err.println(t);
		}
	}

	public void delete(Person person) {
		em.getTransaction().begin();
		try {
			em.remove(person);
			em.getTransaction().commit();
		} catch (Throwable t) {
			em.getTransaction().rollback();
			System.err.println(t);
		}
	}

	@Override
	public void delete(Long id) {
		delete(em.getReference(Person.class, id));
	}
}
