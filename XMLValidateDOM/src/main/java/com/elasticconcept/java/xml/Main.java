package com.elasticconcept.java.xml;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) throws Exception {
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema();
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource(new File("users.xml")));
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("users.xml"));
		
		Element rootTag = doc.getDocumentElement();
		
		NodeList userTagList = rootTag.getElementsByTagName("user");
		
		for (int i = 0; i < userTagList.getLength(); i++) {
			Element userTag = (Element) userTagList.item(i);
			
			String id = userTag.getAttribute("id");
			String name = userTag.getElementsByTagName("name").item(0).getTextContent();
			String age = userTag.getElementsByTagName("age").item(0).getTextContent();
			String email = userTag.getElementsByTagName("email").item(0).getTextContent();
			
			System.out.println(id + ", " + name + ", " + age + ", " + email);
		}
	}
}
