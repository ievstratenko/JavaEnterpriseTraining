package ua.com.javastartup.enterprise.address.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import ua.com.javastartup.enterprise.person.model.Person;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String city;
	String street;
	@ManyToMany(mappedBy = "address")
	Set<Person> owner = new TreeSet<>();

	public Address() {
		super();
	}

	public Address(String city, String street) {
		this.city = city;
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street="
				+ street + "]";
	}

}
