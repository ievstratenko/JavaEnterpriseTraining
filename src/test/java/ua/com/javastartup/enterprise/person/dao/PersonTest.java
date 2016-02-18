package ua.com.javastartup.enterprise.person.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.javastartup.enterprise.person.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/testContext.xml")
public class PersonTest
		extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	PersonService service;

	@Test
	public void dummyTest() {
		Assert.assertNotNull(service.findOne(1L));
	}

}
