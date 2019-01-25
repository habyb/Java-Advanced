package com.elasticconcept.java.xml;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {

	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element usersTag = doc.createElement("users");
		doc.appendChild(usersTag);

		Element userTag = doc.createElement("user");
		userTag.setAttribute("id", "1");
		usersTag.appendChild(userTag);

		Element nameTag = doc.createElement("name");
		nameTag.setTextContent("John Doe Fiancé");
		userTag.appendChild(nameTag);

		Element ageTag = doc.createElement("age");
		ageTag.setTextContent("30");
		userTag.appendChild(ageTag);

		Element emailTag = doc.createElement("email");
		emailTag.setTextContent("john@xyz.com");
		userTag.appendChild(emailTag);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();

		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
//		trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

		DOMSource source = new DOMSource(doc);

		try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("users.xml"), "UTF-8")) {
			StreamResult result = new StreamResult(osw);
			trans.transform(source, result);
		}
	}
}
