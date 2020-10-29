package main;

public class Customer {

	private String firstName;
	private String secondName;
	private String id;

	Customer() {
		// Nope;
	}

	public Customer setFirstname(String value) {
		this.firstName = value;
		return this;

	}

	public Customer setSecondname(String value) {
		this.secondName = value;
		return this;

	}

	public Customer setId(String value) {
		this.id = value;
		return this;

	}

	public String build() {

		return String.format("%s-%s-%s", id, firstName, secondName);

	}

}
