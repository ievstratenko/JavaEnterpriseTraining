package ua.com.javastartup.enterprise.person.service;

import org.springframework.transaction.annotation.Transactional;

import ua.com.javastartup.enterprise.person.dao.PersonDao;
import ua.com.javastartup.enterprise.person.model.Person;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public Person findById(Long id) {
		return personDao.findById(id);
	}

	@Transactional
	public void save(Person person) {
		personDao.save(person);
	}

	@Transactional
	public void delete(Person person) {
		personDao.delete(person);
	}

	@Transactional
	public void delete(Long id) {
		personDao.delete(id);
	}

}
