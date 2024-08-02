package com.example;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(Lifecycle.PER_CLASS)
public class StudentTest {

	@ParameterizedTest
	@MethodSource("getStudents")
	public void checkPassed(Student student) {

		Assertions.assertTrue(student.getMarks() >= 35,
				String.format("%s is not passed with %s marks", student.getName(), student.getMarks()));

	}

	public Stream<Student> getStudents() {
		return Stream.of(new Student("mark", 35), new Student("john", 40), new Student("kely", 43));
	}
}
