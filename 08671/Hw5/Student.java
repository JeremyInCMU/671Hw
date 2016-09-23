/*
 * This class is created to model a single student.
 * It includes first name, last name, andrew id and phone number of a student.
 *
 * @author Jiaming Xiao
 */
public class Student {
    /*
     * Define instance variables for features of a student.
     */
    private String firstName = null, lastName = null, andrewid, phoneNumber = null;
    /*
     * Constructor.
     * @param string andrewId
     */
    public Student (String andrewId) {
        super();
        this.andrewid = andrewId;
    }
    /*
     * Get andrew id of current student.
     * @return String andrewID
     */
    protected String getAndrewId() {
        return this.andrewid;
    }
    /*
     * Get first name of current student.
     * @ return String firstName
     */
    protected String getFirstName() {
        return this.firstName;
    }
    /*
     * Get last name of current student.
     * @ return String lastName
     */
    protected String getLastName() {
        return this.lastName;
    }
    /*
     * Get phone number of current student.
     * @ return String phoneNumber
     */
    protected String getPhoneNumber() {
        return this.phoneNumber;
    }
    /*
     * Set first name of current student.
     * @param String s
     */
    protected void setFirstName(String s) {
        if (this.firstName != null || s == null){
            return;
        }
        this.firstName = s;
    }
    /*
     * Set last name of current student.
     * @param String s
     */
    protected void setLastName(String s) {
        if (this. lastName != null || s == null){
            return;
        }
        this.lastName = s;
    }
    /*
     * Set phone number of current student.
     * @param String s
     */
    protected void setPhoneNumber(String s) {
        if (this.phoneNumber != null || s == null){
            return;
        }
        this.phoneNumber = s;
    }
    /*
     * Print string representation of this class.
     * @return String representation
     */
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " +  "(AndrewID:" + this.andrewid + ", Phone Number:" + this.phoneNumber + ")"; 
    }
} 
