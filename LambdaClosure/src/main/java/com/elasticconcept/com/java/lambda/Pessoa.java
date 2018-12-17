package com.elasticconcept.com.java.lambda;

public class Pessoa {

	private int idade;
	
	public Pessoa(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public double calcularFator() {
		double setting = 0.2; // final implict
		FactorCalculator calc = () -> idade * 10 /2 * setting;
		
//		setting = 0.5; // ERROR: Local variable setting defined in an enclosing scope must be final or effectively final
		return calc.calculate();
	}		
		
}
