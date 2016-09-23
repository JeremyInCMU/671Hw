/*
 * This class is created to test the built class student.
 *
 * @author Jeremy
 */
public class StudentTest {
    public static void main (String[] args) {
        Student std = new Student(args[0]);
        std.setFirstName(args[1]);
        std.setLastName(args[2]);
        std.setPhoneNumber(args[3]);
        System.out.println(std.toString());
        System.out.println(std.getFirstName());
        System.out.println(std.getLastName());
        System.out.println(std.getPhoneNumber());
    }
}
