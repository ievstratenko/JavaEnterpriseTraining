package ua.com.javastartup.enterprise.person.service;

import java.util.List;

import ua.com.javastartup.enterprise.person.model.Person;

public interface PersonService {

	Person findOne(Long id);

	List<Person> findAll();
	
	List<Person> findByName(String name);	

	void save(Person person);

	void delete(Person person);

	void delete(Long id);

}