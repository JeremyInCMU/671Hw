import java.util.List;
import java.util.HashMap;
import java.util.Map;
/*
 * This class uses the three Maps to maintain the collection of students.
 *
 * @author Jiaming Xiao
 */
public class Directory() {
    private HashMap<String, Student> hashMapAndrewId = new HashMap<String, Student>();
    private HashMap<String, List<Student>> hashMapFirstName = new HashMap<String, ArrayList<Student>>();
    private HashMap<String, List<Student>> hashMapLastName = new HashMap<String, ArrayList<Student>>();
    /*
     * Constructor.
     */
    public Directory() {
        super();
    }
    /*
     * Add a student object into the three maps.
     * @param Student a student object
     */
    public void addStudent(Student s) {
        /*
         * Define local variables to get andrewId, firstName and lastName.
         */
        String andrewId = s.getAndrewId();
        String firstName = s.getFirstName();
        String lastName = s.getLastName();
        if (this.searchByAndrewId(andrewId) == null) {
            throw new IllegalArgumentException(String.toString(andrewId));
        } else {
            hashMapAndrewId.put(andrewId, s);
            List<Student> stdListFirst = this.searchByFirstName(firstName);
            if (stdListFirst.length == 0) {
                stdListFirst.add(s);
                this.hashMapFirstName.put(firstName, stdListFirst);
            } else {
                stdListFirst.add(s);
            }
            List<Student> stdListLast = this.searchByLastName(lastName);
            if (stdListLast.length == 0) {
                stdListLast.add(s);
                this.hashMapLastName.put(lastName, stdListLast);
            } else {
                stdListLast.add(s);
            }
       }
    }
    /*
     * Delete a student object from the three maps.
     * @param String andrewId
     */
    public void deleteStudent(String andrewId) {
       /*
        * Define local variable to store the target student.
        */
       Student tarStd = this.searchByAndrewId(andrewId);
       String firstName, lastName; 
       if ( tarStd == null ) {
           throw new IllegalArgumentException(String.toString(andrewId));
       } else {
           this.hashMapAndrewId.remove(andrewId);
           firstName = tarStd.getFirstName();
           List<student>stdListFirst = this.searchByFirstName(firstName);
           if ( stdListFirst.size() == 1 ) {
               this.hashMapFirstName.remove( firstName );
           } else if ( stdListFirst.size() > 1) {
               for (Student std : stdListFirst) {
                   if ( std.andrewId.compareTo(andrewId) == 0 ) {
                       stdListFirst.remove( std );
                       break;
                   }
               }
           }
           lastName = tarStd.getLastName();
           List<student>stdListLast = this.searchByLastName(lastName);
           if ( stdListLast.size() == 1 ) {
               this.hashMapLastName.remove( lastName );
           } else {
               for (Student std : stdListLast) {
                   if ( std.andrewId.compareTo(andrewId) == 0 ) {
                       stdListLast.remove(std);
                       break;
                   }
               }
           }
       }
    }
    /*
     * Search by andrew ID.
     * @param String andrewId
     * @return Student the student object with the input andrewId
     */
    public Student seaerchByAndrewId(String andrewId) {
        return this.hashMapAndrewId.get(andrewId);
    }
    /*
     * Search by first name.
     * @param String firstName
     * @return List<Student> The array list containing students
     */
    public List<Student> searchByFirstName(String firstName) {
        if (this.hashMapFirstName.get(firstName) != null) {
            return this.hashMapFirstName.get(firstName);
        } else {
            return new ArrayList<Student>();
        }
    }
    /*
     * Search by last name.
     * @param String lastName
     * @return List<Student> The array list containing students
     */
    public List<Student> searchByLastName(String lastName) {
        if (this.hashMapLastName.get(lastName) != null) {
            return this.hashMapFirstName.get(lastName);
        } else {
            return new ArrayList<Student>();
        }
    }
}
