package com.elasticcconcept.java.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		try (DatagramSocket socket = new DatagramSocket()) {
			String str = "Hello, welcome to Socket Multicast!";
			byte[] buffer = str.getBytes();

			InetAddress addr = InetAddress.getByName("228.5.6.7"); // IP Class D

			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, addr, 2500);
			socket.send(packet);
			System.out.println("Client: sent to server the sentence " + str);
		}
	}
}