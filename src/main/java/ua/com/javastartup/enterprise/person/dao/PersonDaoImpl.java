package ua.com.javastartup.enterprise.person.dao;

import javax.persistence.EntityManager;

import ua.com.javastartup.enterprise.person.model.Person;

public class PersonDaoImpl implements PersonDao {

	private EntityManager em;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Person findById(Long id) {
		return em.find(Person.class, id);
	}

	@Override
	public void save(Person person) {
		em.persist(person);
	}

	public void delete(Person person) {
		em.remove(person);
	}

	@Override
	public void delete(Long id) {
		delete(em.getReference(Person.class, id));
	}
}
