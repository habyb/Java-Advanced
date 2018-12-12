package com.elasticconcept.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Class<Television> tvClass = Television.class;
		
		// Retrieve the structure of the Television class
		Field[] fields = tvClass.getDeclaredFields();
		
		for (Field field : fields) {
			System.out.println(field.getName() + " => " + field.getType());
		}
		
		System.out.println();
		
		// Retrieve the methods
		Method[] methods = tvClass.getDeclaredMethods();
		
		for (Method method : methods) {
			System.out.println(method.getName() + ", " + method.getReturnType() + ", " + Arrays.toString(method.getParameters()));
		}
		
		System.out.println();
		
		Television tv1 = new Television();
		
		Method switchChannel = tvClass.getDeclaredMethod("switchChannel", int.class);
		switchChannel.invoke(tv1, 7);
		
		Method turnedon = tvClass.getDeclaredMethod("on");
		turnedon.invoke(tv1);
		
	}
}
