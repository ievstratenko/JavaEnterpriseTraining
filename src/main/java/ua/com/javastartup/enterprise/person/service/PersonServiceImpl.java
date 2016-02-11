package ua.com.javastartup.enterprise.person.service;

import ua.com.javastartup.enterprise.person.dao.PersonDao;
import ua.com.javastartup.enterprise.person.model.Person;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;	

	public PersonServiceImpl(PersonDao personDao) {
		this.personDao = personDao;
	}

	public Person findById(Long id) {
		return personDao.findById(id);
	}

	public void save(Person person) {
		personDao.save(person);
	}

	public void delete(Person person) {
		personDao.delete(person);
	}

	public void delete(Long id) {
		personDao.delete(id);
	}

}
