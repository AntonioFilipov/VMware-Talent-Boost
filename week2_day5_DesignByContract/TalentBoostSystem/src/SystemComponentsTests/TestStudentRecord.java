package SystemComponentsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SystemComponents.Course;
import SystemComponents.CourseMark;
import SystemComponents.StudentRecord;

public class TestStudentRecord {
    private Course course;
    private CourseMark mark;
    private StudentRecord record;
    @Before
    public void setUp() throws Exception {
        this.course = new Course("I/O", "Input/Output");
        this.mark = new CourseMark(23,23);
        this.record = new StudentRecord();
    }

    @Test
    public void testAddRecord() {
        record.addRecord(course, mark);
        assertTrue(record.getStudentRecord().containsKey(course));
        assertTrue(record.getStudentRecord().containsValue(mark));
    }
    
    @Test
    public void testGetCourseMarks() {
        record.addRecord(course, mark);
        assertEquals(mark.toString(),record.getCourseMarks(course));
    }
    
    @Test
    public void getAllMarks() {
        record.addRecord(course, mark);
        assertEquals("Course:"+course.getName()+" Entry test:"+mark.getEntryTest()+ " Exit test:"+mark.getExitTest() + '\n', record.getAllMarks());
    }

}
