package com.elasticcconcept.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccount extends Remote {
	void withdraw(double value) throws RemoteException;
	
	void deposit(double value) throws RemoteException;
	
	void transfer(double value, BankAccount otherAccount) throws RemoteException;
	
	double getBalance() throws RemoteException;
}

