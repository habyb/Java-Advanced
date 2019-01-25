package com.elasticconcept.java.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
	
	private StringBuilder text;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parse started!");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Parse ended!");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("user")) {
			String id = attributes.getValue("id");
			System.out.println("Read the ID " + id);
		
		} else {
			text = new StringBuilder();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("name")) {
			System.out.println("Name: " + text);
		} else if (qName.equals("age")) {
			System.out.println("Age: " + text);	
		} else if (qName.equals("email")) {
			System.out.println("Email: " + text);	
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch, start, length);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		
	}
}
