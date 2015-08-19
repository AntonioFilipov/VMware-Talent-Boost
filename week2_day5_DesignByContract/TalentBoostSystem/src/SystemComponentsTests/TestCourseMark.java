package SystemComponentsTests;

import static org.junit.Assert.*;

import org.junit.Test;

import SystemComponents.CourseMark;

public class TestCourseMark {

    private CourseMark mark;

    @Test
    public void testValidEntryTestMark() {
        this.mark = new CourseMark(23,23);
        assertEquals(23, this.mark.getEntryTest());
    }
    
    @Test
    public void testValidExitTestMark() {
        this.mark = new CourseMark(23,23);
        assertEquals(23, this.mark.getEntryTest());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInValidEntryTestMark() {
        this.mark = new CourseMark(-1,23);
        this.mark = new CourseMark(101,23);

    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInValidExitTestMark() {
        this.mark = new CourseMark(-1,23);
        this.mark = new CourseMark(101,23);

    }

}
