package SystemComponentsTests;

import static org.junit.Assert.*;

import org.junit.Test;

import SystemComponents.Course;

public class TestCourse {

    private Course course;

    @Test
    public void testValidCourseName() {
        this.course = new Course("I/O", "Input/Output");
        assertEquals("I/O", this.course.getName());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInValidCourseName() {
        this.course = new Course("", "Input/Output");
        this.course = new Course(null, "null");
    }
    
    @Test
    public void testValidDescriptionName() {
        this.course = new Course("I/O", "Input/Output");
        assertEquals("Input/Output", this.course.getDescription());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInValidDescriptionName() {
        this.course = new Course("I/O", "");
        this.course = new Course("Design", null);
    }

}
