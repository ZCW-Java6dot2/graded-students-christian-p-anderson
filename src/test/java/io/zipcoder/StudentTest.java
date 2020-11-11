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
        testStudent.getFirstName();

        // Then
        String actual = testStudent.getFirstName();
        Assert.assertEquals(expected, actual);
    }

}