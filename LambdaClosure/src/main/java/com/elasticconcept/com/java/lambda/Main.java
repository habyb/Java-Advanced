package com.elasticconcept.com.java.lambda;

public class Main {

	public static void main(String[] args) {
	
		Pessoa p = new Pessoa(28);
//		p.setIdade(10);
		double factor = p.calcularFator();
		System.out.println(factor);
	}

}
