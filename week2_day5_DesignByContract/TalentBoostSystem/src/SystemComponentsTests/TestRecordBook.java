package SystemComponentsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import SystemComponents.Course;
import SystemComponents.CourseMark;
import SystemComponents.Gender;
import SystemComponents.RecordBook;
import SystemComponents.Student;
import SystemComponents.StudentRecord;

public class TestRecordBook {
    private Student student;
    private Course course;
    private CourseMark mark;
    private StudentRecord studentRecord;
    private RecordBook bookRecord;

    @Before
    public void setUp() throws Exception {
        this.student = new Student("Gosho", Gender.MALE, 20, "SF");
        this.course = new Course("I/O", "Input/Output");
        this.mark = new CourseMark(12,32);
        this.studentRecord = new StudentRecord();
        studentRecord.addRecord(course, mark);
        this.bookRecord = new RecordBook();
        bookRecord.addRecord(student, studentRecord);

    }

    @Test
    public void testAddRecord() {
        assertTrue(bookRecord.getBookRecord().containsKey(student));
        assertTrue(bookRecord.getBookRecord().containsValue(studentRecord));
    }

    @Test
    public void testGetRecord() {
        String result = bookRecord.getRecord(student);
        assertEquals(student.getName() + "\n" + bookRecord.getBookRecord().get(student).getAllMarks(), result);
    }


}
