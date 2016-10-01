/*
 * This class is defined to test directory class.
 *
 * @author Jeremy
 */
public class DirectoryTest {
   /*
    * Define attributes of students
    */
   String andrewId, firstName, lastName, phoneNumber;
   public static void main(String[] args){
       Directory dir = new Directory();
       Student std1 = new Student("terrylee");
       std1.setFirstName("terry");
       std1.setLastName("lee");
       std1.setPhoneNumber("412-268-1078");
    
       Student std2 = new Student("jeffepinger");
       std2.setFirstName("jeff");
       std2.setLastName("epinger");
       std2.setPhoneNumber("412-268-1474");
    
       Student std3 = new Student("terryhong");
       std3.setFirstName("terry");
       std3.setLastName("hong");
       std3.setPhoneNumber("412-464-4756");
    
       Student std4 = new Student("jefflee");
       std4.setFirstName("jeff");
       std4.setLastName("lee");
       std4.setPhoneNumber("412-268-7182");
       
       dir.addStudent(std1);
       dir.addStudent(std2);
       dir.addStudent(std3);
       dir.addStudent(std4);
       dir.addStudent(null);

       System.out.println(dir.searchByAndrewId("terry lee"));
       System.out.println(dir.searchByFirstName("terry"));
       System.out.println(dir.searchByLastName("lee"));
       System.out.println(dir.searchByAndrewId(null));
       System.out.println(dir.searchByFirstName(null));
       System.out.println(dir.searchByLastName(null));

       dir.deleteStudent(null);
       
       /*
       dir.deleteStudent(std.getAndrewId());
       System.out.println(dir.searchByAndrewId(args[0]));
       System.out.println(dir.searchByFirstName(args[1]));
       System.out.println(dir.searchByLastName(args[2]));
       */
   }
}
