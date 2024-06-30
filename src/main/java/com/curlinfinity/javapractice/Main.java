package com.curlinfinity.javapractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	
	private final static List<Student> allStudents = Arrays.asList(
		new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
		new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
		new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
		new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
		new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
		new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
		new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
		new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
		new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
		new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98)
	);

	public static void main(String[] args) {
		// 1- Find list of students whose first name starts with alphabet A
		List<Student> studentsStartsWithA = allStudents.stream()
				.filter(s -> s.getFirstName().startsWith("A"))
				.toList();
		System.out.println("Students whose name starts with \"A\":");
		studentsStartsWithA.forEach(System.out::println);
		System.out.println();
		
		// 2- Group The Student By Department Names
		Map<String, List<Student>> studentDeptWise = allStudents.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.toList()));
		System.out.println("Student grouped by department:");
		studentDeptWise.entrySet().forEach(System.out::println);
		System.out.println();
		
		// 3- Find the total count of student using stream
		long totalStudents = allStudents.stream().count();
		System.out.println("Total students: " + totalStudents);
		System.out.println();
		
		// 4- Find the max age of student
		Student studentWithMaxAge = allStudents.stream()
				.max(Comparator.comparing(Student::getAge))
				.orElse(null);
		System.out.println("Student with max age: " + studentWithMaxAge);
		System.out.println();
		
		// 5- Find all departments names
		List<String> allDepartnameNames = allStudents.stream()
				.map(Student::getDepartmentName)
				.toList();
		System.out.println("All department names:");
		allDepartnameNames.forEach(System.out::println);
		System.out.println();
		
		// 6- Find the count of student in each department
		Map<String, Long> deptWiseStudentCount = allStudents.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
		System.out.println("Department wise students count: ");
		deptWiseStudentCount.entrySet().forEach(System.out::println);
		System.out.println();
		
		// 7- Find the list of students whose age is less than 30
		List<Student> studentLessThan30 = allStudents.stream()
				.filter(s -> s.getAge() < 30)
				.toList();
		System.out.println("Student whose age less than 30: ");
		studentLessThan30.forEach(System.out::println);
		System.out.println();
		
		// 8- Find the list of students whose rank is in between 50 and 100
		List<Student> studentWithRankBetween50_100 = allStudents.stream()
				.filter(s -> s.getRank() > 50 && s.getRank() < 100)
				.toList();
		System.out.println("Student with rank between 50 and 100:");
		studentWithRankBetween50_100.forEach(System.out::println);
		System.out.println();
		
		// 9- Find the average age of male and female students
		Map<String, Double> averageAgeSexWise = allStudents.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
		System.out.println("Sex wise average age:");
		averageAgeSexWise.entrySet().forEach(System.out::println);
		System.out.println();
		
		// 10- Find the department who is having maximum number of students
		Map.Entry<String, Long> deptNameWithMaxStudent = allStudents.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue())
				.get();
		System.out.println("Department with max student:\n" + deptNameWithMaxStudent);
		System.out.println();
		
		// 11- Find the Students who stays in Delhi and sort them by their names
		List<Student> delhiStudentsSortedByName = allStudents.stream()
				.filter(s -> "Delhi".equalsIgnoreCase(s.getCity()))
				.sorted(Comparator.comparing(Student::getFirstName))
				.toList();
		System.out.println("Student in delhi sorted by name:");
		delhiStudentsSortedByName.forEach(System.out::println);
		System.out.println();
		
		// 12- Find the average rank in all departments
		Map<String, Double> deptWiseRankAverage = allStudents.stream()
				.collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingInt(Student::getRank)));
		System.out.println("Department wise rank average:");
		deptWiseRankAverage.entrySet().forEach(System.out::println);
		System.out.println();
		
		// 13- Find the highest rank in each department
		Map<String, Optional<Student>> deptWiseHighestRank = allStudents.stream()
				.collect(Collectors.groupingBy(
					Student::getDepartmentName,
					Collectors.maxBy(Comparator.comparing(Student::getRank)
				)));
		System.out.println("Highest rank in each department");
		deptWiseHighestRank.entrySet().forEach(System.out::println);
		System.out.println();
		
		// 14- Find the list of students and sort them by their rank
		List<Student> sortedByRank = allStudents.stream()
				.sorted(Comparator.comparing(Student::getRank))
				.toList();
		System.out.println("Students sorted by rank:");
		sortedByRank.forEach(System.out::println);
		System.out.println();
		
		// 15- Find the student who has second rank
		Student secondRankStudent = allStudents.stream()
				.sorted(Comparator.comparing(Student::getRank))
				.skip(1)
				.findFirst()
				.orElse(null);
		System.out.println("Student with second rank: " + secondRankStudent);
		System.out.println();
	}

}
