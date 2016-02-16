package ua.com.javastartup.enterprise.person.service;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.javastartup.enterprise.person.dao.PersonDao;
import ua.com.javastartup.enterprise.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonDao personDao;

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
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("PRE DESTROY");
	}

}
