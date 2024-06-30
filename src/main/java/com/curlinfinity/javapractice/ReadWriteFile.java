package com.curlinfinity.javapractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadWriteFile {
	
	private final static String[] words = {
		"hello",
		"level",
		"world",
		"racecar"
	};
	private static final String fileName = "words.txt";
	
	public static void main(String[] args) {
		try {
			// write words to file using stream (not io stream)
			writeToFile();
			System.out.println("Words written to files");
			System.out.println();
			
			System.out.println("Reading words from file");
			readWordsFromFile().forEach(System.out::println);
			System.out.println();
			
			System.out.println("Reading palindromes from file");
			readPalindromsFromFile().forEach(System.out::println);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void writeToFile() throws IOException {
		try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get(fileName)))) {
			Arrays.stream(words).forEach(pw::println);
		}
	}
	
	private static List<String> readWordsFromFile() throws IOException {
		return Files.readAllLines(Paths.get(fileName)).stream()
			.toList();
	}
	
	private static List<String> readPalindromsFromFile() throws IOException {
		return Files.readAllLines(Paths.get(fileName)).stream()
			.filter(ReadWriteFile::isPalindrom)
			.toList();
	}
	
	private static boolean isPalindrom(String word) {
		return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
	}
	
}