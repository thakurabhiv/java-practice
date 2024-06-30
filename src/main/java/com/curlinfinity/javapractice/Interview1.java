package com.curlinfinity.javapractice;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview1 {
	public static void main(String[] args) {
		// Given a string, find a first non repeating character
		// using java stream
		String string = "Hi Abhishek, how are you";
		
		Character firstNonRepeatingChar = string.chars()
				.mapToObj(c -> Character.toLowerCase((char) c))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.filter(e -> e.getValue() == 1L)
				.map(Map.Entry::getKey)
				.findFirst()
				.orElse(null);
		
		System.out.printf("First non repeating character in string \"%s\" is \"%s\"", string, firstNonRepeatingChar);
	}
}