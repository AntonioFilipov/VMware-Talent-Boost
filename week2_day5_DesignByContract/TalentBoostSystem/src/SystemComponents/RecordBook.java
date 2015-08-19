package SystemComponents;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores Students and their records
 * 
 * @author Antonio
 *
 */
public class RecordBook {
    private Map<Student, StudentRecord> bookRecord;

    public RecordBook() {
        this.bookRecord = new HashMap<Student, StudentRecord>();
    }
    
    public Map<Student, StudentRecord> getBookRecord(){
        return this.bookRecord;
    }

    /**
     * add record to student
     * 
     * @param student
     *            student you want to add in the record book.
     * @param record
     *            student courses and marks
     */
    public void addRecord(Student student, StudentRecord record) {
        this.bookRecord.put(student, record);
    }

    /**
     * get records for student
     * 
     * @param student
     *            student you want to get all marks
     * @return string with name of the student and all marks of student
     */
    public String getRecord(Student student) {
        if (bookRecord.containsKey(student)) {
            return student.getName() + "\n" + bookRecord.get(student).getAllMarks();
        }
        return null;
    }

}
