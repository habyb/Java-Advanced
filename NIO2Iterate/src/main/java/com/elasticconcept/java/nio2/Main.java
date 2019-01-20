package com.elasticconcept.java.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Path dir = Paths.get("/Users/habyb/Desktop/Temp");
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.tx?")) { // Glob: a*.pdf
			for (Path path : stream) {
				System.out.println(path);
			}
		}
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, p -> Files.size(p) > 100)) {
			for (Path path : stream) {
				System.out.println(path);
			}
		}
	
		SearchFile searchFile = new SearchFile("txt");
		Files.walkFileTree(dir, searchFile);
	}
}
