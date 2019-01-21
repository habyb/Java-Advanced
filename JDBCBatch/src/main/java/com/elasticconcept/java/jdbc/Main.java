package com.elasticconcept.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost/jdbc?useSSL=false&serverTimezone=UTC";

		try (Connection conn = DriverManager.getConnection(url, "root", "root1234")) {
			System.out.println("Database connected");

			String sql = "INSERT INTO product (name) VALUES (?)";

			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				for (int i = 1; i <= 1000; i++) {
					stmt.setString(1, "Product " + i);
					stmt.addBatch();
				}
				
				stmt.executeBatch();
			}
		}
	}
}
