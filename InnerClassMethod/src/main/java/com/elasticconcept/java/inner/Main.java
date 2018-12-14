package com.elasticconcept.java.inner;

public class Main {

	public static void main(String[] args) {
		
		String t2 = "Method Variable"; // (final is implicit) final is optional, ie: final String t2 ...
		
		class Text {
			private String t;
			
			public Text(String t) {
				this.t = t;
			}
			
			public void print() {
				System.out.println(t);
			}
			
			public void print2() {
				/*
				 The final local variable t2 cannot be assigned, since it is defined in an enclosing type
				 Local variable t2 defined in an enclosing scope must be final or effectively final
				*/
//				t2 = "Other Text"; // t2 value can not be changed
				System.out.println(t2);
			}
		}
		
		Text txt = new Text("My Text");
		txt.print();
		txt.print2();
	}
}
