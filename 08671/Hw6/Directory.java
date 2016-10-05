import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * This class uses the three Maps to maintain the collection of students.
 *
 * @author Jiaming Xiao
 */
public class Directory {
    /** Define a hashmap with adnrewId. */
    private Map<String, Student> hashMapAndrewId =
                                 new HashMap<String, Student>();
    /** Define a hashmap with first name. */
    private Map<String, List<Student>> hashMapFirstName =
                                 new HashMap<String, List<Student>>();
    /** Define a hashmap with last name. */
    private Map<String, List<Student>> hashMapLastName =
                                 new HashMap<String, List<Student>>();
    /** Constructor. */
    public Directory() {
        super();
    }
    /**
     * Add a student object into the three maps.
     * @param s a student object.
     * @throws {IllegalArgumentException}
     */
    public void addStudent(Student s) {
        if (s instanceof Student) {
            String andrewId = s.getAndrewId();
            String firstName = s.getFirstName();
            String lastName = s.getLastName();
            if (this.searchByAndrewId(andrewId) != null) {
                 throw new IllegalArgumentException("This student already in the directory");
            } else {
                this.hashMapAndrewId.put(andrewId, s);
                List<Student> stdListFirst = this.searchByFirstName(firstName);
                if (stdListFirst.size() == 0) {
                    stdListFirst.add(s);
                    this.hashMapFirstName.put(firstName, stdListFirst);
                } else {
                    stdListFirst.add(s);
                }
                List<Student> stdListLast = this.searchByLastName(lastName);
                if (stdListLast.size() == 0) {
                    stdListLast.add(s);
                    this.hashMapLastName.put(lastName, stdListLast);
                } else {
                    stdListLast.add(s);
                }
           }
        } else {
               throw new IllegalArgumentException("The input student is illegal");
        }
    }
    /**
     * Delete a student object from the three maps.
     * @param andrewId andrewID of student.
     */
    public void deleteStudent(String andrewId) {
       Student tarStd = this.searchByAndrewId(andrewId);
       String firstName, lastName;
       if (tarStd == null) {
           throw new IllegalArgumentException("Student with the andrewId is not in our directory");
       } else {
           this.hashMapAndrewId.remove(andrewId);
           firstName = tarStd.getFirstName();
           List<Student> stdListFirst = this.searchByFirstName(firstName);
           if (stdListFirst.size() == 1) {
               this.hashMapFirstName.remove(firstName);
           } else if (stdListFirst.size() > 1) {
               for (Student std : stdListFirst) {
                   if (std.getAndrewId().compareTo(andrewId) == 0) {
                       stdListFirst.remove(std);
                       break;
                   }
               }
          }
          lastName = tarStd.getLastName();
          List<Student> stdListLast = this.searchByLastName(lastName);
          if (stdListLast.size() == 1) {
              this.hashMapLastName.remove(lastName);
          } else {
              for (Student std : stdListLast) {
                   if (std.getAndrewId().compareTo(andrewId) == 0) {
                       stdListLast.remove(std);
                       break;
                   }
              }
          }
       }
    }
    /**
     * Search by andrew ID.
     * @param andrewId andrewID of student.
     * @return Student the student object with the input andrewId
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId instanceof String) {
                return this.hashMapAndrewId.get(andrewId);
        } else {
            throw new IllegalArgumentException("The intput andrewId is illegal");
        }
    }
    /**
     * Search by first name.
     * @param firstName first name of student.
     * @return List<Student> The array list containing students
     */
    public List<Student> searchByFirstName(String firstName) {
        if (firstName instanceof String) {
            if (this.hashMapFirstName.get(firstName) != null) {
                return this.hashMapFirstName.get(firstName);
            } else {
                return new ArrayList<Student>();
            }
        } else {
            throw new IllegalArgumentException("The input andrewId is illegal");
        }
    }
    /**
     * Search by last name.
     * @param lastName last name of student.
     * @return List<Student> The array list containing students
     */
    public List<Student> searchByLastName(String lastName) {
        if (lastName instanceof String) {
            if (this.hashMapLastName.get(lastName) != null) {
                return this.hashMapLastName.get(lastName);
            } else {
                return new ArrayList<Student>();
            }
        } else {
            throw new IllegalArgumentException("The input andrewId is illegal");
        }
    }
    /**
     * Get size of students in the directory.
     * @return int size the size of students in the directory
     */
    public int size() {
        return this.hashMapAndrewId.size();
    }
}
