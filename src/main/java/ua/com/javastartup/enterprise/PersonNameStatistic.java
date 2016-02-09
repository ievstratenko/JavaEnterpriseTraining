package ua.com.javastartup.enterprise;

public class PersonNameStatistic {
	Integer personCount;
	String name;

	public PersonNameStatistic(long personCount,
			String name) {
		this.personCount = (int) personCount;
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonNameStatistic [personCount=" + personCount
				+ ", name=" + name + "]";
	}

}
