import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CohortTest {

    Cohort emptyCohort;
    Cohort cohortWithOne;
    Cohort cohortWithMany;

    @Before
    public void setup(){
        emptyCohort = new Cohort();
        cohortWithOne = new Cohort();
        cohortWithMany = new Cohort();

        Student fer = new Student(1, "Fernando Mendoza");
        fer.addGrade(90);

        Student trant = new Student(2, "Trant Batey");
        trant.addGrade(100);
        trant.addGrade(100);
        trant.addGrade(100);

        cohortWithOne.addStudent(fer);
        cohortWithMany.addStudent(fer);
        cohortWithMany.addStudent(trant);
    }

    //A Cohort instance can add a Student to the List of students.
    @Test
    public void testAddStudentWorks(){
        cohortWithMany.addStudent(new Student(3, "Zach Gulde"));
        // We can test if addStudent worked by getting a specific student's name
        assertEquals("Zach Gulde", cohortWithMany.getStudents().get(2).getName());
        cohortWithMany.addStudent(new Student(4, "Vivian Canales"));
        // Or we can test if addStudent worked by checking the size of the list
        assertEquals(4, cohortWithMany.getStudents().size());
    }

    //A Cohort instance can get the current List of students.
    @Test
    public void testIfGetStudentsWork(){
        assertEquals(0, emptyCohort.getStudents().size());
        assertEquals(1, cohortWithOne.getStudents().size());

        assertEquals(1, cohortWithMany.getStudents().get(0).getId());
        assertEquals(2, cohortWithMany.getStudents().get(1).getId());
    }

    //A Cohort instance can get the average, and it's being calculated correctly.
    @Test
    public void testIfAvgIsCorrect(){
        assertEquals(Double.NaN, emptyCohort.getCohortAverage(), 0);
        assertEquals(90.0, cohortWithOne.getCohortAverage(), 0);
        assertEquals(95.0, cohortWithMany.getCohortAverage(), 0);
    }

}