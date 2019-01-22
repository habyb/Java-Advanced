package com.elasticconcept.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost/jdbc?useSSL=false&serverTimezone=UTC";

		try (Connection conn = DriverManager.getConnection(url, "root", "root1234")) {
			System.out.println("Database connected");

			String sql1 = "INSERT INTO product (id, name) VALUES (?, ?)";
			String sql2 = "INSERT INTO item (product_id, price) VALUES (?, ?)";

			try (PreparedStatement stmt1 = conn.prepareStatement(sql1);
				 PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
				
				conn.setAutoCommit(false);
				
				try {
					stmt1.setInt(1, 1);
					stmt1.setString(2, "Bean");
					stmt1.executeUpdate();
					
					stmt2.setInt(1, 1);
					stmt2.setDouble(2, 3.5);
					stmt2.executeUpdate();
					
					// Intentional error
//					Object o = null;
//					o.toString();
					
					stmt2.setInt(1, 1);
					stmt2.setDouble(2, 4.7);
					stmt2.executeUpdate();
					
					conn.commit();
				
				} catch (Exception e) {
					conn.rollback();
					throw e;
				}
			}
		}
	}
}
