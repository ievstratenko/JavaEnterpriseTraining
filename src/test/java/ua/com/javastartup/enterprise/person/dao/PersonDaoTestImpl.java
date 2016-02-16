package ua.com.javastartup.enterprise.person.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ua.com.javastartup.enterprise.person.model.Person;

@Repository
public class PersonDaoTestImpl implements PersonDao {

	Map<Long, Person> storage = new HashMap<>();
	long counter = 1;

	@Override
	public Person findById(Long id) {
		return storage.get(id);
	}

	@Override
	public void save(Person person) {
		if (person.getId() == null) {
			person.setId(counter++);
		}
		storage.put(person.getId(), person);
	}

	public void delete(Person person) {
		delete(person.getId());
	}

	@Override
	public void delete(Long id) {
		storage.remove(id);
	}
}
