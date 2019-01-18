package com.elasticcconcept.java.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

	public static void main(String[] args) throws Exception {
		BankAccount account1 = new BankAccountImpl();
		//BankAccount accountStub1 = (BankAccount) UnicastRemoteObject.exportObject(account1, 0);
		
		BankAccount account2 = new BankAccountImpl();
		//BankAccount accountStub2 = (BankAccount) UnicastRemoteObject.exportObject(account2, 0);
		
		Registry registry = LocateRegistry.createRegistry(1099);
//		registry.rebind("account1", accountStub1);
//		registry.rebind("account2", accountStub2);
		
		registry.rebind("account1", account1);
		registry.rebind("account2", account2);
		
		System.out.println("Waiting for requisitions");
	}
}