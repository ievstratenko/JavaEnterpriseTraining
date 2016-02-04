package ua.com.javastartup.enterprise;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String city;
	String street;
	@ManyToOne
	@JoinTable(name = "person_address")
	Person owner;

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
