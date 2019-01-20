package com.elasticconcept.java.nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchFile implements FileVisitor<Path> {

	private String fileName;
	
	public SearchFile(String fileName) {;
		this.fileName = fileName;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("Entering directory " + dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("Accessing the file " + file);
		
		if (file.getFileName().toString().contains(fileName)) {
			System.out.println("File found in " + file);
			return FileVisitResult.TERMINATE;
		}
		
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.out.println("Failed to access file " + file + ": " + exc);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.println("Exiting Directory " + dir);
		return FileVisitResult.CONTINUE;
	}
}
