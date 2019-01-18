package com.elasticcconcept.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TCPClient {

	public static void main(String[] args) throws Exception {
		try (Socket socket = new Socket("localhost", 2323)) {
			System.out.println("Client connected to server");

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			int amount = 2;
			
			out.println("PAYMENT");
			out.println(amount);
			
			for (int i = 0; i < amount; i++) {
				String status = sendPayment("John Doe", "3215665389488674", YearMonth.of(2035, 11), 1, 345.67, in, out);
				
				if (status == null) {
					System.out.println("Successful payment!");
				} else {
					System.out.println("Error: " + status);
				}
			}
		}
	}
	
	private static String sendPayment(String name, String cardNumber, YearMonth cardExpirationDate, int paymentInstallments, double total, BufferedReader in, PrintWriter out) throws IOException {
		out.println(String.format("%s;%s;%s;%d;%s", name, cardNumber, cardExpirationDate.format(DateTimeFormatter.ofPattern("MM/yyyy")), paymentInstallments, String.valueOf(total)));
		
		String status = in.readLine();

		if (status.equals("OK")) {
			return null;
		} else {
			return status;
		}
	}
}
