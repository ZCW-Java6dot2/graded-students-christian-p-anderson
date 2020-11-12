package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ClassroomTest {

    @Test
    public void constructorReturnsNothingTest() {
        // Given
        Student[] students = new Student[0];
        Classroom testClassroom = new Classroom(students);
        // When
        Student[] expected = {};
        // Then
        Student[] actual = testClassroom.getStudents();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorDefineMaxStudentsTest() {
        //Given
        Classroom testClassroom = new Classroom(15);
        // When
        int expected = 15;
        // Then
        int actual = testClassroom.getStudents().length;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorNullTest() {
        // Given
        Classroom testClassroom = new Classroom();
        // When
        int expected = 30;
        // Then
        int actual = testClassroom.getStudents().length;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        Double[] sallyScores = {100.0, 95.0};
        Double[] samScores = {85.0, 78.0};
        Student sally = new Student("Sally", "Long", sallyScores);
        Student sam = new Student("Sam", "Long", samScores);
        Student[] students = new Student[]{sally, sam};
        Classroom testClassroom = new Classroom(students);

        // When
        int actual = (int) testClassroom.getAverageExamScore();
        int expected = 90;

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest() {
        // Given
        Double[] johnScores = {96.0, 89.0};
        Student john = new Student("John", "Doe", johnScores);
        Classroom testClassroom = new Classroom(1);

        // When
        Student[] expected = {john};
        testClassroom.addStudent(john);

        // Then
        Student[] actual = testClassroom.getStudents();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeStudentTest() {
        // Given
        Double[] janeScores = {96.0, 89.0};
        Double[] johnScores = {91.0, 93.0};
        Student jane = new Student("Jane", "Doe", janeScores);
        Student john = new Student("John", "Doe", johnScores);
        Classroom testClassroom = new Classroom(3);

        // When
        testClassroom.addStudent(jane);
        testClassroom.addStudent(john);
        Boolean actual = testClassroom.removeStudent("Jane", "Doe");

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void getStudentsByScoreTest() {
        // Given
        Double[] janeScores = {8.0, 8.0, 8.0};
        Double[] johnScores = {11.0, 11.0, 11.0};
        Double[] loriScores = {5.0, 5.0, 5.0};
        Student jane = new Student("Jane", "Doe", janeScores);
        Student john = new Student("John", "Doe", johnScores);
        Student lori = new Student("Lori", "Doe", loriScores);
        Classroom testClassroom = new Classroom(3);

        // When
        testClassroom.addStudent(jane);
        testClassroom.addStudent(john);
        testClassroom.addStudent(lori);
        Student[] expected = {lori, jane, john};

        // Then
        Student[] actual = testClassroom.getStudentsByScore();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getGradeBookTest() {
        // Given
        Double[] janeScores = {80.0, 82.0};
        Double[] johnScores = {51.0, 52.0};
        Double[] loriScores = {21.0, 25.0};
        Student jane = new Student("Jane", "Doe", janeScores);
        Student john = new Student("John", "Doe", johnScores);
        Student lori = new Student("Lori", "Doe", loriScores);
        Classroom testClassroom = new Classroom(3);

        // When
        testClassroom.addStudent(jane);
        testClassroom.addStudent(john);
        testClassroom.addStudent(lori);
        HashMap<Student, String> expected = new HashMap<>();
        expected.put(john, "A");
        expected.put(jane, "A");
        expected.put(lori, "D");

        // Then
        HashMap<Student, String> actual = testClassroom.getGradeBook();
        Assert.assertEquals(expected, actual);
    }

}
