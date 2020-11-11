package io.zipcoder;

public class Classroom {

    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }

    public double getAverageExamScore() {
        double sumOfAllStudentAverageExamScores = 0.00;

        for (Student student : students) {
            if (student != null) {
                sumOfAllStudentAverageExamScores += student.getAverageExamScore();
            }
        }

        return Math.round(sumOfAllStudentAverageExamScores / students.length);
    }
}
