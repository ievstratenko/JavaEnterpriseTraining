package ua.com.javastartup.enterprise;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
	String speciality;

	public Student(String name, String speciality) {
		super(name);
		this.speciality = speciality;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [speciality=" + speciality + ", id=" + id
				+ ", name=" + name + ", address=" + address
				+ ", phoneNumbers=" + phoneNumbers + "]";
	}
}
