package com.elasticconcept.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		create();
		load();
	}

	private static void create() throws Exception {
		Address address = new Address();
		address.setStreet("Fifth Street");
		address.setNumber(3000);
		
		User user = new User();
		user.setId(20);
		user.setName("John");
		user.setAddress(address);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
			oos.writeObject(user);
		}
	}
	
	private static void load() throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
			User user = (User) ois.readObject();
			System.out.println(user);
		}
	}
}
