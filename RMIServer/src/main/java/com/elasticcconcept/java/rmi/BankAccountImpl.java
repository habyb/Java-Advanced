package com.elasticcconcept.java.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//public class BankAccountImpl implements BankAccount {
public class BankAccountImpl extends UnicastRemoteObject implements BankAccount {
	private static final long serialVersionUID = 1L;
	
	private double balance;
	
	protected BankAccountImpl() throws RemoteException {
	}
	
	public void withdraw(double value) throws RemoteException {
		this.balance -= value;
	}
	
	public void deposit(double value) throws RemoteException {
		this.balance += value;
	}
	
	public void transfer(double value, BankAccount otherAccount) throws RemoteException {
		withdraw(value);
		otherAccount.deposit(value);
	}
	
	public double getBalance() throws RemoteException {
		return balance;
	}
}