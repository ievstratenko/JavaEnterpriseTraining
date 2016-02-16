package ua.com.javastartup.enterprise.person.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.com.javastartup.enterprise.person.model.Person;

public interface PersonDao extends JpaRepository<Person, Long> {

	List<Person> findByName(String name);

	@Query("from Person where name=:name and age=:age")
	List<Person> findByCustomCriteria(@Param("name") String name,
			@Param("age") Integer age);

	@Transactional
	@Modifying
	@Query("update Person set name=?2 where name=?1")
	int setNewName(String oldName, String newName);

}