package com.elasticcconcept.java.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		try (DatagramSocket socket = new DatagramSocket()) {
			String str = "Hello, welcome to UDP/IP!";
			byte[] buffer = str.getBytes();

			InetAddress addr = InetAddress.getLocalHost();
//			InetAddress addr = InetAddress.getByName("String host");

			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, addr, 2500);
			socket.send(packet);
			System.out.println("Client: sent to server the sentence " + str);
		}
	}
}