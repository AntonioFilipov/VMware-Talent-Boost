package SystemComponents;

/**
 * Contains the marks from entryTest and exitTest of a student for every course
 * 
 * @author Antonio
 *
 */
public class CourseMark {
    private int entryTest;
    private int exitTest;

    /**
     *
     * @param entryTest
     *            integer number with value more than 0 and less than 100.
     * 
     * @param exitTest
     *            set exitTest marks with preconditions <li>This is Integer
     *            number with value more than 0. <li>This is Integer number with
     *            value less than 100.
     * 
     * @throws ValidationException
     */
    public CourseMark(int entryTest, int exitTest) {
        this.setEntryTest(entryTest);
        this.setExitTest(exitTest);

    }

    /**
     * get entryTest mark
     * 
     * @return
     */
    public int getEntryTest() {
        return entryTest;
    }

    /**
     * set entyTest mark
     * 
     * @param entryTest
     *            integer number with value more than 0 and less than 100.
     * @throws IllegalArgumentException 
     */
    public void setEntryTest(int entryTest) {
        if (!ValidationFunctions.markValidation(entryTest)) {
            throw new IllegalArgumentException("Mark cannot be less than 0 or more than 100!");
        }
        this.entryTest = entryTest;
    }

    /**
     * get exitTest mark
     * 
     * @return
     */
    public int getExitTest() {
        return exitTest;
    }

    /**
     * set exitTest mark
     * 
     * @param entryTest
     *            integer number with value more than 0 and less than 100.
     * @throws IllegalArgumentException 
     */
    public void setExitTest(int exitTest) {
        if (!ValidationFunctions.markValidation(exitTest)) {
            throw new IllegalArgumentException("Mark cannot be less than 0 or more than 100!");
        }
        this.exitTest = exitTest;
    }
    
    @Override
    public String toString() {
        return "entryTest=" + entryTest + ", exitTest=" + exitTest;
    }
}
