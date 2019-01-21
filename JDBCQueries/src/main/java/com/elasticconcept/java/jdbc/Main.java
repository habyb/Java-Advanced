package com.elasticconcept.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {

		String[] productNames = { "Bean", "Potato", "Onion", "Tomato" };

		String url = "jdbc:mysql://localhost/jdbc?useSSL=false&serverTimezone=UTC";

		try (Connection conn = DriverManager.getConnection(url, "root", "root1234")) {
			System.out.println("Connected to database");

//			String sql = "INSERT INTO product (name) VALUES ('Rice')";
//			
//			 try (Statement stmt = conn.createStatement()) {
//				 stmt.executeUpdate(sql);
//				 System.out.println("Product inserted");
//			 }

			try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO product (name) VALUES (?)")) {
				for (String productName : productNames) {
					stmt.setString(1, productName); // First position starts at 1
					stmt.executeUpdate();
				}
			}
		}
	}
}