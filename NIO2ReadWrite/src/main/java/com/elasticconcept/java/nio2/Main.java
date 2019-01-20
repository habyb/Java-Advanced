package com.elasticconcept.java.nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Path p1 = Paths.get("/Users/habyb/Desktop/Temp/myfile1.txt");
		Path p2 = Paths.get("/Users/habyb/Desktop/Temp/myfile2.pdf");

		Path p3 = Paths.get("/Users/habyb/Desktop/Temp/myfile3.txt");
		Path p4 = Paths.get("/Users/habyb/Desktop/Temp/myfile4.pdf");

		InputStream in = Files.newInputStream(p2); // newInputStream: Binary Files
		try (BufferedReader reader = Files.newBufferedReader(p1)) { // newBufferedReader: Text Files
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}

		// Small files
		byte[] bytes = Files.readAllBytes(p2); // Binary Files
		List<String> lines = Files.readAllLines(p1); // Text files

		for (String line : lines) {
			System.out.println(line);
		}

		try (OutputStream os = Files.newOutputStream(p4)) { // Binary Files
			os.write(20);
		}

		try (BufferedWriter writer = Files.newBufferedWriter(p3)) { // Text files
			writer.write("Hello");
		}

		byte[] bytes2 = Files.readAllBytes(p2); // Binary Files
		Files.write(p4, bytes2, StandardOpenOption.CREATE);

		List<String> lines2 = Files.readAllLines(p1); // Text files
		Files.write(p3, lines2, StandardOpenOption.CREATE);
	}

}
