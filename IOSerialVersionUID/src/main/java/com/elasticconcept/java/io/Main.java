package com.elasticconcept.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		serialize();
		unserialize();
	}

	private static void serialize() throws Exception {
		User user = new User();
		user.setId(5);
		user.setName("Peter");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.bin"))) {
			oos.writeObject(user);
		}
	}
	
	private static void unserialize() throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"))) {
			User user = (User) ois.readObject();
			System.out.println(user);
		}
	}
}