package com.elasticconcept.java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

	public static void main(String[] args) throws IOException {
		Path p1 = Paths.get("/Users/habyb/Desktop/Temp/file.txt");
		Path p2 = Paths.get("/Users", "habyb", "Desktop", "Temp", "file.txt");
		
		System.out.println(p1);
		System.out.println(p2);
		
		Path p3 = Paths.get("myfile.ini");
		System.out.println(p3);
		
		Path p4 = Paths.get("Users", "habyb", "Desktop", "Temp");
		System.out.println(p4);
		
		Path p5 = p4.resolve(p3);
		System.out.println(p5);
		
		Path p = Paths.get("/Users", "habyb", "Desktop", "Temp", "file.txt");
		System.out.println(p.getFileName());
		System.out.println(p.getRoot());
		System.out.println(p.getNameCount());
		System.out.println(p.getName(0));
		
		Path p6 = Paths.get("/Users/habyb/Desktop/Temp/text.txt");
		Path p7 = Paths.get("/Users/habyb/Desktop/Temp/text2.txt");
		
		boolean exists = Files.exists(p);
		System.out.println(exists);
		
		Files.copy(p6, p7, StandardCopyOption.REPLACE_EXISTING);
		Files.delete(p7);
		Files.deleteIfExists(p7);
		
		Files.createFile(p7);
		Files.createTempFile(Paths.get("/Users/habyb/Desktop/Temp/"), "temp_", ".tmp");
		
		Files.createDirectories(Paths.get("/Users/habyb/Desktop/Temp/Dir/Dir2/Dir3"));
		Path p8 = Files.createTempDirectory(Paths.get("/Users/habyb/Desktop/Temp"), "tmp");
		System.out.println(p8);
	}
}

