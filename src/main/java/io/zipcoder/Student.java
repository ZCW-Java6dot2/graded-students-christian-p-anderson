package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class Student {
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

    public ArrayList<Double> getTestScores() {
        return this.examScores;
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
            formatListScores.format("Exam %d -> %0.2f%n", (this.examScores.indexOf(examScore)) + 1, examScore);
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

    public Double getAverageExamScore() {
        double count = this.examScores.size();
        double sum = 0;
        double answer = sum / count;

        for (Double examScore : this.examScores) {
            sum += examScore;
        }

        return answer;
    }

    @Override
    public String toString() {
        StringBuilder studentReport = new StringBuilder();
        Formatter formattedString = new Formatter(studentReport);
        formattedString.format("Student Name: %s %n> Average Score: %s%n> Exam Scores:%n",
                this.getFirstName(),
                this.getLastName(),
                this.getAverageExamScore(),
                this.getExamScores()
                );

        return studentReport.toString().trim();
    }
}
