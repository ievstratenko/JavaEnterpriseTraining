package ua.com.javastartup.enterprise.person.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.javastartup.enterprise.person.model.Person;

public interface PersonDao extends JpaRepository<Person, Long> {

	List<Person> findByName(String name);
}