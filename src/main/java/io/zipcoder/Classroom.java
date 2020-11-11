package io.zipcoder;

//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.*;

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

    /**
     * use a for loop to create an array the size of the class and assign their reference to the array elements
     * this allows us to add a student to the array. Check if the value at the element is null, if so this is the
     * next empty spot in the array. Add the student to this empty spot. Return true if the method is successful and
     * false if it's not successful
     */
    public Boolean addStudent(Student student) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] == null) {
                this.students[i] = student;
                return true;
            }
        }
        return false;
    }

    /**
     * convert array to an ArrayList. find if the student exists, if so store the student object so we can remove it
     * from the ArrayList. remove student and then convert the ArrayList back to an array
     */
    public Boolean removeStudent(String firstName, String lastName) {
       Student studentToBeRemoved = null;

       for (Student student : this.students) {
           if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
               studentToBeRemoved = student;
               break;
           }
       }

       if (studentToBeRemoved == null) {
           return false;
       } else {
           ArrayList<Student> studentsList = new ArrayList<>(Arrays.asList(this.students));
           studentsList.remove(studentToBeRemoved);

           this.students = studentsList.toArray(this.students);
           return true;
       }
    }

    /**
     *
     * convert the this.students array into an ArrayList. Use Collections to sort the ArrayList. Return the array
     *
     * using the Collections.sort returned an error. Found the reason in the site referenced below:
     * https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
     *
     */
    public Student[] getStudentsByScore() {
        ArrayList<Student> studentsList = new ArrayList<>(Arrays.asList(this.students));

        Collections.sort(studentsList);

        return studentsList.toArray(this.students);

    }

//    public void getGradeBook
}
