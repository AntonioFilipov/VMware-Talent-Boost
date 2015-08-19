package SystemComponentsTests;

import static org.junit.Assert.*;

import org.junit.Test;

import SystemComponents.CourseMark;
import SystemComponents.Gender;
import SystemComponents.Student;

public class TestStudent {

    private Student student;
    
    @Test
    public void testValidStudentName() {
        this.student = new Student("Gosho", Gender.MALE, 20, "SF");
        assertEquals("Gosho", this.student.getName());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInValidStudentName() {
        this.student = new Student("", Gender.MALE, 20, "SF");
        this.student = new Student(null, Gender.MALE, 20, "SF");

    }

    @Test
    public void testValidStudentAge() {
        this.student = new Student("Gosho", Gender.MALE, 20, "SF");
        assertEquals(20, this.student.getAge());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInValidStudentAge() {
        this.student = new Student("Gosho", Gender.MALE, -1, "SF");
        this.student = new Student("Gosho", Gender.MALE, 2200, "SF");
    }
    
    @Test
    public void testValidStudentUniversity() {
        this.student = new Student("Gosho", Gender.MALE, 20, "SF");
        assertEquals("SF", this.student.getUniversity());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void tesIntValidStudentUniversity() {
        this.student = new Student("Gosho", Gender.MALE, 20, "");
        this.student = new Student("Gosho", Gender.MALE, 20, null);
    }
}
