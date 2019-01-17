package com.elasticcconcept.java.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		try (ServerSocket serverSocket = new ServerSocket(1050)) {
			System.out.println("Server: waiting for requisitions...");
			Socket clientSocket = serverSocket.accept();

			InputStream socketIn = clientSocket.getInputStream();
			DataInputStream din = new DataInputStream(socketIn);

			int value = din.readInt();
			System.out.println("Server: received the value " + value);
			value++;

			OutputStream socketOut = clientSocket.getOutputStream();
			DataOutputStream dout = new DataOutputStream(socketOut);
			dout.writeInt(value);
			System.out.println("Server: sent the value " + value);
		}
	}
}
