package com.elasticconcept.java.generics;

public class Main {

	public static void main(String[] args) {
		
		Buffer b = new Buffer();
		
		b.adicionar("a");
		b.adicionar("b");
		b.adicionar("c");
		
		String e1 = b.remover();
		String e2 = b.remover();
		String e3 = b.remover();
		
		System.out.println(e1 + ", " + e2 + ", " + e3);
	}
}
