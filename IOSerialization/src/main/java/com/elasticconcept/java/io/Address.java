package com.elasticconcept.java.io;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String street;
	private int number;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + "]";
	}
}
