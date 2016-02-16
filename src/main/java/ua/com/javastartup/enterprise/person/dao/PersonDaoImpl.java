package ua.com.javastartup.enterprise.person.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ua.com.javastartup.enterprise.person.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager em;
	
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
