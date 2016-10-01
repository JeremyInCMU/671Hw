/**
 *
 * This class is created to model a single student. It includes first name,
 * last name, andrew id and phone number of a student.
 *
 * @author Jiaming Xiao
 */
public class Student {
    /** Define first name of student. */
    private String firstName = null;
    /** Define last name of student. */
    private String lastName = null;
    /** Define andrew Id of student. */
    private String andrewid;
    /** Define phone number of student. */
    private String phoneNumber = null;
    /**
     * Constructor.
     * @param andrewId adnrewId of student.
     */
    public Student(String andrewId) {
        super();
        this.andrewid = andrewId;
    }
    /**
     * Get andrew id of current student.
     * @return andrewID
     */
    public String getAndrewId() {
        return this.andrewid;
    }
    /**
     * Get first name of current student.
     * @return firstName
     */
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * Get last name of current student.
     * @return lastName
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * Get phone number of current student.
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    /**
     * Set first name of current student.
     * @param s first name of student
     */
    public void setFirstName(String s) {
        if (this.firstName != null || s == null || s == "") {
            return;
        }
        this.firstName = s;
    }
    /**
     * Set last name of current student.
     * @param s last name of student
     */
    public void setLastName(String s) {
        if (this.lastName != null || s == null || s == "") {
            return;
        }
        this.lastName = s;
    }
    /**
     * Set phone number of current student.
     * @param s phonenumber of student.
     */
    public void setPhoneNumber(String s) {
        if (this.phoneNumber != null || s == null || s == "") {
            return;
        }
        this.phoneNumber = s;
    }
    /**
     * Print string representation of this class.
     * @return String representation
     */
    @Override
    public String toString() {
        String updatedFirstName = nameConverter(this.firstName);
        String updatedLastName = nameConverter(this.lastName);
        return updatedFirstName + " " + updatedLastName + " "
               + "(Andrew ID: " + this.andrewid + ", Phone Number: "
               + this.phoneNumber + ")";
    }
    /**
     * To upper case the first character of string.
     * @param name the name of student.
     * @return String updated name
     */
    private String nameConverter(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
