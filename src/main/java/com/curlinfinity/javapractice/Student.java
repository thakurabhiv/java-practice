package com.curlinfinity.javapractice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String departmentName;
	private int joinedYear;
	private String city;
	private int rank;
}