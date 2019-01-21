package com.elasticconcept.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost/jdbc?useSSL=false&serverTimezone=UTC";

		try (Connection conn = DriverManager.getConnection(url, "root", "root1234")) {
			System.out.println("Database connected");

			String sql = "SELECT id, name FROM product";

			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						//int id = rs.getInt(0);
						//String name = rs.getString(1);

						int id = rs.getInt("id");
						String name = rs.getString("name");

						System.out.println("id = " + id);
						System.out.println("name = " + name);
						System.out.println("=========================");
					}
				}
			}
		}
	}
}