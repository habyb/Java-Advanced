package com.elasticcconcept.java.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws Exception {
		try (Socket socket = new Socket("localhost", 1050)) {
			System.out.println("Client: conected to server");
			int value = 5;

			OutputStream socketOut = socket.getOutputStream();
			DataOutputStream dout = new DataOutputStream(socketOut);
			dout.writeInt(value);
			System.out.println("Client: value " + value + " sent to server");

			InputStream socketIn = socket.getInputStream();
			DataInputStream din = new DataInputStream(socketIn);
			int incrementedValue = din.readInt();

			System.out.println("Client: received from server the value " + incrementedValue);
		}
	}
}
