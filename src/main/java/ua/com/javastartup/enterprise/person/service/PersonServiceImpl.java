package ua.com.javastartup.enterprise.person.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.javastartup.enterprise.person.dao.PersonDao;
import ua.com.javastartup.enterprise.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonDao personDao;

	public Person findOne(Long id) {
		return personDao.findOne(id);
	}

	public List<Person> findAll() {
		return personDao.findAll();
	}

	@Transactional
	public Person save(Person person) {
		return personDao.save(person);
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
