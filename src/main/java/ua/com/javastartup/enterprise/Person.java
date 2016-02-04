package ua.com.javastartup.enterprise;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "addressPerson",
			joinColumns = @JoinColumn(name = "personId"),
			inverseJoinColumns = @JoinColumn(name = "addressId") )
	private List<Address> address = new ArrayList<>();

	public Person() {
		super();
	}

	public Person(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address="
				+ address + "]";
	}
}
