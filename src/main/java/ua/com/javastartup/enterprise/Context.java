package ua.com.javastartup.enterprise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {
	private static final ApplicationContext INSTANCE = new ClassPathXmlApplicationContext(
			"appContext.xml");

	private Context() {
	}

	public static ApplicationContext getInstance() {
		return INSTANCE;
	}
}
