package com.elasticconcept.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Buffer {

	private List<String> list = new ArrayList<>();
	
	public void adicionar(String elemento) {
		list.add(elemento);
	}
	
	public String remover() {
		String elemento = list.get(0);
		list.remove(0);
		return elemento;
	}
}
