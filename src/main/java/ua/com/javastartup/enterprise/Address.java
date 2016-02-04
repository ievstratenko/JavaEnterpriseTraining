package ua.com.javastartup.enterprise;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	String city;
	String street;	

	public Address() {
		super();
	}

	public Address(String city, String street) {
		this.city = city;
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street="
				+ street + "]";
	}

}
