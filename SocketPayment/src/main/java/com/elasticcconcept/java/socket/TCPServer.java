package com.elasticcconcept.java.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.NumberFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TCPServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ServerSocket socket = new ServerSocket(2323);

		while (true) {
			System.out.println("Waiting for requisitions...");
			Socket clientSocket = socket.accept();

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			String tipo = in.readLine();

			if (tipo.equals("PAYMENT")) {
				processPayment(in, out);
			} else {
				// Process other types of request
			}
		}
	}

	private static void processPayment(BufferedReader in, PrintWriter out) {
		int qtd;
		try {
			qtd = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			out.println("FAIL " + e.getMessage());
			return;
		}

		for (int i = 0; i < qtd; i++) {
			try {
				String paymentStr = in.readLine();
				String[] tokens = paymentStr.split(";");

				String name = tokens[0];
				String cardNumber = tokens[1];
				YearMonth cardExpirationDate = YearMonth.parse(tokens[2], DateTimeFormatter.ofPattern("MM/yyyy"));
				int paymentInstallments = Integer.parseInt(tokens[3]);
				double total = Double.parseDouble(tokens[4]);

				System.out.println("Payment received (" + (i + 1) + ")");
				System.out.println("Name: " + name);
				System.out.println("Card Number: " + cardNumber);
				System.out.println("Card expiration date: " + cardExpirationDate);
				System.out.println("Payment installments: " + paymentInstallments);
				System.out.println("Total: " + NumberFormat.getCurrencyInstance().format(total));

				out.println("OK");
			
			} catch (Exception e) {
				out.println("FAIL " + e.getMessage());
			}
		}
	}
}
