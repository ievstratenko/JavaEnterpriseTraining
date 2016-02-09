package ua.com.javastartup.enterprise.person.model;

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
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;

import ua.com.javastartup.enterprise.address.model.Address;

@Entity
@NamedQuery(name = "Person.findByName",
		query = "from Person where name like :pattern")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	// @Version
	// private Integer version;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "addressPerson",
			joinColumns = @JoinColumn(name = "personId") ,
			inverseJoinColumns = @JoinColumn(name = "addressId") )
	private List<Address> address = new ArrayList<>();

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@PrePersist
	public void prePersist() {
		System.out.println("==== Prepersist");
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address="
				+ address + "]";
	}
}
