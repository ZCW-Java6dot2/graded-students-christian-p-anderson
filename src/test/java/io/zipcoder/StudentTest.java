package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    private Student testStudent;

    @Before
    public void setup() {
        Double[] defaultExamScores = {84.00, 72.00, 91.00};
        this.testStudent = new Student("Christian", "Anderson", defaultExamScores);
    }

    @Test
    public void setFirstNameTest() {
        // Given
        String expected = "Charlie";

        // When
        testStudent.setFirstName(expected);

        // Then
        String actual = testStudent.getFirstName();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getFirstNameTest() {
        // Given
        String expected = "Christian";

        // When
        String actual = testStudent.getFirstName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastNameTest() {
        // Given
        String expected = "Hansen";

        // When
        testStudent.setLastName(expected);

        // Then
        String actual = testStudent.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastNameTest() {
        // Given
        String expected = "Anderson";

        // When
        String actual = testStudent.getLastName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        // Given
        int expected = 3;

        // When
        int actual = testStudent.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest() {
        // Given
        testStudent.addExamScore(100.00);

        // When
        String actual = testStudent.getExamScores();

        // Then
        Assert.assertEquals("Exam 1 -> 84.00\nExam 2 -> 72.00\nExam 3 -> 91.00\nExam 4 -> 100.00", actual);
    }

    @Test
    public void getExamScoresTest() {
        // Given
        String expected = "Exam 1 -> 84.00\nExam 2 -> 72.00\nExam 3 -> 91.00";

        // When
        String actual = testStudent.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        double expected = 82;

        // When
        double actual = testStudent.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void setExamScoreTest() {
        // Given
        String expected = "Exam 1 -> 80.00\nExam 2 -> 72.00\nExam 3 -> 91.00";

        // When
        testStudent.setExamScore(1, 80.00);
        String actual = testStudent.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        // Given
        String expected = "Student Name: Christian Anderson\n" +
                "> Average Score: 82.0\n" +
                "> Exam Scores:\n" +
                "Exam 1 -> 84.00\n" +
                "Exam 2 -> 72.00\n" +
                "Exam 3 -> 91.00";

        // When
        String actual = testStudent.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

















}