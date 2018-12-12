package com.elasticconcept.java.reflection;

public class Television {

	private boolean turnedon;
	private int channel;
	
	public Television() {
		System.out.println("TV was created");
	}
	
	public void on() {
		turnedon = true;
		System.out.println("TV is On");
	}
	
	public void off() {
		turnedon = false;
		System.out.println("TV is Off");
	}
	
	public void switchChannel(int newChannel) {
		channel = newChannel;
		System.out.println("Channel was switched to " + newChannel);
	}
	
	public boolean isTurnedon() {
		return turnedon;
	}
	
	public int getChannel() {
		return channel;
	}
}
