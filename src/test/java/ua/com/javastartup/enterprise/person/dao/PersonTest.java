package ua.com.javastartup.enterprise.person.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.javastartup.enterprise.person.model.Person;
import ua.com.javastartup.enterprise.person.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/testContext.xml")
@Rollback(false)
public class PersonTest
		extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	PersonService service;

	@Test
	public void dummyTest() {
		service.save(new Person("Tom"));
	}

}
