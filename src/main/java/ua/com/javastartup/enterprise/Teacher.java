package ua.com.javastartup.enterprise;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {
	Double salary;

	public Teacher(String name, Double salary) {
		super(name);
		this.salary = salary;
	}

	public Teacher() {
		super();
	}

	@Override
	public String toString() {
		return "Student [salary=" + salary + ", id="
				+ id + ", name=" + name + "]";
	}
}
