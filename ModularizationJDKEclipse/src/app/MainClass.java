package app;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("users.xml"));
		
		Element rootTag = doc.getDocumentElement();
		
		NodeList userTagList = rootTag.getElementsByTagName("user");
		
		for (int i = 0; i < userTagList.getLength(); i++) {
			Element usersTag = (Element) userTagList.item(i);
			
			String id = usersTag.getAttribute("id");
			String name = usersTag.getElementsByTagName("name").item(0).getTextContent();
			String age = usersTag.getElementsByTagName("age").item(0).getTextContent();
			String email = usersTag.getElementsByTagName("email").item(0).getTextContent();
			
			System.out.println(id + ", " + name + ", " + age + ", " + email);
		}
	}
}
