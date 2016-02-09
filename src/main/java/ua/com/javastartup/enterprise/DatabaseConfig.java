package ua.com.javastartup.enterprise;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConfig {
	public static final EntityManagerFactory EMF = Persistence
			.createEntityManagerFactory("emf");
}
