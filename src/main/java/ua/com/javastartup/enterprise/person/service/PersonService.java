package ua.com.javastartup.enterprise.person.service;

import ua.com.javastartup.enterprise.person.model.Person;

public interface PersonService {

	Person findById(Long id);

	void save(Person person);

	void delete(Person person);

	void delete(Long id);

}