package ua.com.javastartup.enterprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	@ElementCollection
	List<Address> address = new ArrayList<>();
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "person_phone_number",
			joinColumns = @JoinColumn(name = "person_id") )
	@Column(name = "phone_number")
	@MapKeyColumn(name = "number_type")
	Map<String, String> phoneNumbers = new HashMap<>();

	public Person() {
		super();
	}

	public Person(String name) {
		this.name = name;
	}

	public Map<String, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<String, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address="
				+ address + "]";
	}
}
