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
	}

	public void demoReadWriteFileAsString() throws IOException, URISyntaxException {
		// Old way: Java 8
		Files.lines(readWritePath).forEach(line -> System.out.println(line));

		System.out.println();
	}

}
