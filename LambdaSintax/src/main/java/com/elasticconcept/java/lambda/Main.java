package com.elasticconcept.java.lambda;

public class Main {

	public static void main(String[] args) {
		
		// Anonymous Class
		Calculator calc = new Calculator() {
			
			@Override
			public void calculate(int x, int y) {
				x = x * x + y;
				System.out.println(x);
				
			}
		};
		
		calc.calculate(10, 5);
		
		System.out.println();
		
		// Lambda Sintax
		Calculator calc2 = (e, f) -> {
			e = e * e;
			System.out.println(e);
		};

		calc2.calculate(7, 1);
		
		System.out.println();
		
		// Other Lambda Sintax
//		Calculator calc = (e, f) -> e = e * e + f;
//		calc.calculate(7, 1);
		
		// Other Lambda Sintax
		Calculator2 calc3 = p -> {
			return p * p;
		};
		System.out.println(calc3.calculate(5));
		
		System.out.println();
		
		// Other Lambda Sintax
		Calculator2 calc4 = p -> p * p;
		System.out.println(calc4.calculate(9));
	}

}
