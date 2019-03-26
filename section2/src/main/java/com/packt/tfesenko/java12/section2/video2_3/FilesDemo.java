package com.packt.tfesenko.java12.section2.video2_3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesDemo {

	private Path readWritePath = Paths.get("src/main/resources/video2_3/filesDemoInput.txt"); // from sources

	private Path comparePath1 = Paths.get(getClass().getClassLoader().getResource("video2_3/fileDemo_match1.txt").getFile()); // from binaries

	private Path comparePath2 = Paths.get(getClass().getClassLoader().getResource("video2_3/fileDemo_match2.txt").getFile());

	private Path comparePath3 = Paths.get(getClass().getClassLoader().getResource("video2_3/fileDemo_match3.txt").getFile());
	
	

	public static void main(String[] args) throws IOException, URISyntaxException {
		var app = new FilesDemo();
		app.demoReadWriteFileAsString();
		app.demoJava12();
	}

	public void demoReadWriteFileAsString() throws IOException, URISyntaxException {
		// Old way: Java 8
		Files.lines(readWritePath).forEach(line -> System.out.println(line));

		System.out.println();
		System.out.println(Files.readString(readWritePath));

		System.out.println();
		Files.writeString(readWritePath, "Three\nTwo\nOne");
		System.out.println(Files.readString(readWritePath));
		System.out.println();
	}

	// Install and enable Java 12 to run this code!!
	public void demoJava12() throws IOException {
//		System.out.println("Same file, same path:");
//		System.out.println(Files.isSameFile(comparePath1, comparePath1));
//		System.out.println(Files.mismatch(comparePath1, comparePath1));
//		System.out.println();
//
//		System.out.println("Identical file content, but different paths:");
//		System.out.println(Files.isSameFile(comparePath1, comparePath2));
//		System.out.println(Files.mismatch(comparePath1, comparePath2));
//		System.out.println();
//
//		System.out.println("Different text in files:");
//		System.out.println(Files.isSameFile(comparePath1, comparePath3));
//		System.out.println(Files.mismatch(comparePath1, comparePath3));
	}
}
