package SystemComponents;

/**
 * Represent a student in TalentBoost
 * 
 * @author admin
 *
 *
 */
public class Student {
    private String name;
    private Gender gender;
    private int age;
    private String university;

    /**
     * 
     * @param name
     *            full name of student (each name separated by space)
     * @param gender
     *            gender of student (male or female)
     * @param age
     *            age of student
     * @param university
     *            student university
     * 
     * */
    public Student(String name, Gender gender, int age, String university) {
        this.setName(name);
        this.setGender(gender);
        this.setAge(age);
        this.setUniversity(university);
    }

    /**
     * @return full name of student (each name separated by space)
     */
    public String getName() {
        return name;
    }

    /**
     * set name of student
     * 
     * @param name
     *            full name of student (each name separated by space)
     * @throws IllegalArgumentException
     *             name is invalid
     */
    private void setName(String name) {
        boolean isString = ValidationFunctions.stringValidation(name);
        if (!isString) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        this.name = name;
    }

    /**
     * @return gender of student
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * set gender of student
     * 
     * @param gender
     *            gender of student (male or female)
     */
    private void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return age of student
     */
    public int getAge() {
        return age;
    }

    /**
     * set age of student
     * 
     * @param age
     *            age of student
     * @throws IllegalArgumentException
     *             age is invalid
     */
    private void setAge(int age) {
        if (age < 0 || age > 200) {
            throw new IllegalArgumentException("Age cannot be less than 0 or more than 200");
        }
        this.age = age;
    }

    /**
     * @return student university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * set student university
     * 
     * @param university
     *            student university
     */
    public void setUniversity(String university) {
        boolean isString = ValidationFunctions.stringValidation(university);
        if (!isString) {
            throw new IllegalArgumentException("University name cannot be null or empty string");
        }
        this.university = university;
    }

}
