package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class Student implements Comparable<Student> {
    private String firstName; // a collection of characters representative of a first name
    private String lastName; // a collection of characters representative of a last name
    private ArrayList<Double> examScores; // a dynamic collection of decimal values representative of test scores

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.examScores = new ArrayList(Arrays.asList(testScores));
        // converted array to an arrayList
        // potential issue with examScores - this will not allow you to dynamically change the size of the list
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public String getExamScores() {
        // transform the ArrayList into a string
        StringBuilder listScores = new StringBuilder();
        Formatter formatListScores = new Formatter(listScores); // Formatter takes a log record and converts it to a string

        // append all scores into the StringBuilder
        for (Double examScore : this.examScores) {
            formatListScores.format("Exam %d -> %.02f%n", (this.examScores.indexOf(examScore)) + 1, examScore);
            // %d is integer, %f is floating point, %n line separator
        }

        return listScores.toString().trim();

    }

    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(int examNum, double updatedScore) {
        this.examScores.set(examNum - 1, updatedScore);
    }

    public double getAverageExamScore() {
        double sum = 0.00;

        for (Double examScore : this.examScores) {
            sum += examScore;
        }

        return Math.round(sum / this.examScores.size());
    }

    @Override
    public String toString() {
        StringBuilder studentReport = new StringBuilder();
        Formatter formattedString = new Formatter(studentReport);
        formattedString.format("Student Name: %s %s%n> Average Score: %s%n> Exam Scores:%n%s%n",
                this.getFirstName(),
                this.getLastName(),
                this.getAverageExamScore(),
                this.getExamScores()
                );

        return studentReport.toString().trim();
    }


    /**
     * we implemented the Comparable interface which causes us to define the compareTo() method. We need to compare
     * one student to another based on average exam scores
     *
     * compareStudentTo is the object to be compared
     * compareTo() returns a negative integer, zero, or a positive integer as this object is less than, equal to, or
     * greater than the specified object.
     */

    @Override
    public int compareTo(Student compareStudentTo) {
        // -1 means what is on the left is less than what is on the right (our comparing value)
        if (this.getAverageExamScore() > compareStudentTo.getAverageExamScore()) {
            return -1;
        }

        // 1 means what is on the left is greater than what is on the right (our comparing value)
        if (this.getAverageExamScore() < compareStudentTo.getAverageExamScore()) {
            return 1;
        }

        // means that the exam scores are equal, so do a string comparison of last name
        return this.getLastName().compareTo(compareStudentTo.getLastName());
    }
}
