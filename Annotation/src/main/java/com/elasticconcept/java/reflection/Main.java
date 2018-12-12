package com.elasticconcept.java.reflection;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
		MyClass mc = new MyClass();
		
		execte(mc);
	}
	
	@SuppressWarnings("unchecked")
	private static void execte(MyClass mc) throws Exception {
		//mc.getClass() EQUAL MyClass.class;
		Class<MyClass> c = (Class<MyClass>) mc.getClass();
		
		Method[] methods = c.getDeclaredMethods();
		
		for(Method m : methods) {
			Execute annot = m.getDeclaredAnnotation(Execute.class);
			
			if(annot != null) {
				String arg = annot.value();
				m.invoke(mc, arg);
			}
		}
	}
}
