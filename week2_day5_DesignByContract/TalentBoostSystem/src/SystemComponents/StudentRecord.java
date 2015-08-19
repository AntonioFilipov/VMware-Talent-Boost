package SystemComponents;

import java.util.HashMap;
import java.util.Map;

/**
 * Store information about the student courses and marks.
 * 
 * @author Antonio
 *
 */
public class StudentRecord {
    private Map<Course, CourseMark> studentRecord;

    public StudentRecord() {
        this.studentRecord = new HashMap<Course, CourseMark>();
    }

    public Map<Course, CourseMark> getStudentRecord() {
        return this.studentRecord;
    }

    /**
     * add record
     * 
     * @param course
     *            course you want to put course marks
     * @param mark
     *            courseMarks you want to put on selected course
     */
    public void addRecord(Course course, CourseMark mark) {
        this.studentRecord.put(course, mark);
    }

    /**
     * get marks of a course
     * 
     * @param course
     *            course you search for course marks
     * @return the Course marks for the course you choose
     */
    public String getCourseMarks(Course course) {
        if (studentRecord.containsKey(course)) {
            return studentRecord.get(course).toString();
        }
        return null;
    }

    /**
     * get all marks for every course
     * 
     * @return string with courses and their marks
     */
    public String getAllMarks() {
        StringBuilder result = new StringBuilder();
        for (Course key : studentRecord.keySet()) {
            String courseName = key.getName();
            int entryTest = studentRecord.get(key).getEntryTest();
            int exitTest = studentRecord.get(key).getExitTest();
            result.append("Course:" + courseName + " Entry test:" + entryTest + " Exit test:" + exitTest + '\n');
        }
        return result.toString();

    }
}
