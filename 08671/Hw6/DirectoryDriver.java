import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.List;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * This class will create a directory driver GUI.
 * @author Jiaming Xiao
 */
public class DirectoryDriver {
    /**
     * Define instance variable of main pane.
     */
    private JPanel mainPane;
    /**
     * Define instance variable of fieldText first name.
     */
    private JTextField fieldFirstName;
    /**
     * Define instance variable of fieldText last name.
     */
    private JTextField fieldLastName;
    /**
     * Define instance variable of fieldText andrew ID in add pane.
     */
    private JTextField fieldAndrewID;
    /**
     * Define instance variable of fieldText phone number.
     */
    private JTextField fieldPhoneNum;
    /**
     * Define instance variable of fieldText andrew ID in delete pane.
     */
    private JTextField fieldDelete;
    /**
     * Define instance variable of fieldText in search pane.
     */
    private JTextField fieldSearchKey;
    /**
     * Define instance variable of add button in add student pane.
     */
    private JButton addButton;
    /**
     * Define instance variable of delete button in delete student pane.
     */
    private JButton deleteButton;
    /**
     * Define instance variable of search by andrew ID button.
     */
    private JButton searchByAndrewIDButton;
    /**
     * Define instance variable of search by first name button.
     */
    private JButton searchByFirstNameButton;
    /**
     * Define instance variable of search by last name button.
     */
    private JButton searchByLastNameButton;
    /**
     * Define instance variable of student directory.
     */
    private Directory studentDirectory;
    /**
     * Define instance variable of text area.
     */
    private JTextArea textAreaResults;
    /**
     * Define instance variable of font.
     */
    private Font font;
    /**
     * Define instance variable of color.
     */
    private Color color;
    /**
     * Define instance variable of action listener.
     */
    private ActionListener listener;
    /**
     * Define instance variable of key listener.
     */
    private KeyListener keylistener;
    /**
     * Constructor where JFrame and other components are instantiated.
     * @param stdDir student directory
     */
    public DirectoryDriver(Directory stdDir) {
        if (stdDir == null) { // Check if there is load csv file
            studentDirectory = new Directory();
        } else {
            studentDirectory = stdDir;
        }
        /**
         * Main frame and main pane
         */
        JFrame frame = new JFrame("Directory Driver");
        frame.setSize(800, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPane = new JPanel(new GridLayout(4, 1));
        font = new Font(Font.SERIF, Font.BOLD, 12);
        color = new Color(100, 149, 237);
        listener = new MyActionListener();
        keylistener = new MyKeyListener();
        new AddStudentPane();
        new DeleteStudentPane();
        new SearchStudentPane();
        /**
         * Pane for Results.
         */
        JPanel paneResults = new JPanel();
        mainPane.add(paneResults);
        LineBorder lineBorderResults = new LineBorder(color, 2);
        TitledBorder borderResults = new TitledBorder(lineBorderResults, "Results");
        borderResults.setTitleColor(color);
        paneResults.setBorder(borderResults);
        /**
         * Text area for result pane.
         */
        textAreaResults = new JTextArea(5, 40);
        textAreaResults.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaResults);
        paneResults.add(scrollPane);
        /**
         * Content pane.
         */
        frame.setContentPane(mainPane);
        frame.setVisible(true);
        fieldSearchKey.requestFocus();
        fieldSearchKey.addKeyListener(keylistener);

    }
    /**
     * Main function to implement the GUI.
     * @param args command line arguments
     * @throws IOException if the file doesn't exist.
     * @throws FileNotFoundException if the file doesn't exist.
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Directory tmp = new Directory();
        if (args.length > 0) {
            FileReader fr = new FileReader(args[0]);
            loadFile(tmp, fr);
        }
        new DirectoryDriver(tmp);
    }
    /**
     * Private nested class to build add student pane and its components.
     * @author Jiaming Xiao
     */
     private class AddStudentPane {
         /**
          * Constructor.
          */
         private AddStudentPane() {
             /**
              * Pane for Add Students.
              */
             JPanel paneAddStudents = new JPanel();
             paneAddStudents.setSize(500, 30);
             mainPane.add(paneAddStudents);
             LineBorder lineBorderAddStudents = new LineBorder(color, 2);
             TitledBorder borderAddStudents = new TitledBorder(lineBorderAddStudents,
                                                               "Add a new student");
             borderAddStudents.setTitleColor(color);
             paneAddStudents.setBorder(borderAddStudents);
             JPanel addLine = new JPanel();
             paneAddStudents.add(addLine);
             /**
              * First name label for add students pane.
              */
             JLabel labelFirstName = new JLabel("First Name:");
             labelFirstName.setFont(font);
             labelFirstName.setForeground(color);
             labelFirstName.setBackground(Color.white);
             labelFirstName.setVerticalTextPosition(JLabel.CENTER);
             paneAddStudents.add(labelFirstName);
             addLine.add(labelFirstName);
             /**
              * First name fieldtext for add students pane.
              */
            fieldFirstName = new JTextField(5);
            addLine.add(fieldFirstName);
            /**
             * Last name label for add students pane.
             */
            JLabel labelLastName = new JLabel("Last Name:");
            labelLastName.setFont(font);
            labelLastName.setForeground(color);
            labelLastName.setBackground(Color.white);
            paneAddStudents.add(labelLastName);
            addLine.add(labelLastName);
            /**
             * Last name field text for add students pane.
             */
            fieldLastName = new JTextField(5);
            addLine.add(fieldLastName);
            /**
             * AndrewID label for add students pane,
             */
            JLabel labelAddAndrewID = new JLabel("Andrew ID:");
            labelAddAndrewID.setFont(font);
            labelAddAndrewID.setForeground(color);
            labelAddAndrewID.setBackground(Color.white);
            paneAddStudents.add(labelAddAndrewID);
            addLine.add(labelAddAndrewID);
            /**
             * AndrewID field text for add students pane.
             */
            fieldAndrewID = new JTextField(5);
            addLine.add(fieldAndrewID);
            /**
             * Phone number label for add students pane.
             */
            JLabel labelAddPhoneNum = new JLabel("Phone Number:");
            labelAddPhoneNum.setFont(font);
            labelAddPhoneNum.setForeground(color);
            labelAddPhoneNum.setBackground(Color.white);
            paneAddStudents.add(labelAddPhoneNum);
            addLine.add(labelAddPhoneNum);
            /**
             * Phone number field text for add students pane.
             */
            fieldPhoneNum = new JTextField(5);
            addLine.add(fieldPhoneNum);
            /**
             * Add button for add students pane.
             */
            addButton = new JButton("Add");
            paneAddStudents.add(addButton);
            addButton.setForeground(color);
            addLine.add(addButton);
            addButton.addActionListener(listener);
         }
     }
    /**
     * Private nested class to create delete pane and components on it.
     * @author Jiaming Xiao
     */
    private class DeleteStudentPane {
        /**
         * Constructor.
         */
        private DeleteStudentPane() {
        /**
         * Pane for Delete Student.
         */
        JPanel paneDeleteStudents = new JPanel();
        mainPane.add(paneDeleteStudents);
        LineBorder lineBorderDeleteStudents = new LineBorder(color, 2);
        TitledBorder borderDeleteStudents = new TitledBorder(lineBorderDeleteStudents, "Delete a student");
        borderDeleteStudents.setTitleColor(color);
        paneDeleteStudents.setBorder(borderDeleteStudents);
        JPanel deleteLine = new JPanel();
        paneDeleteStudents.add(deleteLine);
        /**
         * AndrewID label for delete student pane.
         */
        JLabel labelDeleteAndrewID = new JLabel("Andrew ID:");
        labelDeleteAndrewID.setFont(font);
        labelDeleteAndrewID.setVerticalTextPosition(JLabel.CENTER);
        labelDeleteAndrewID.setForeground(color);
        paneDeleteStudents.add(labelDeleteAndrewID);
        deleteLine.add(labelDeleteAndrewID);
        /**
         * AndrewID field text for delete student pane.
         */
        fieldDelete = new JTextField(5);
        deleteLine.add(fieldDelete);
        /**
         * Delete button for delete student pane.
         */
        deleteButton = new JButton("Delete");
        deleteButton.setForeground(color);
        paneDeleteStudents.add(deleteButton);
        deleteLine.add(deleteButton);
        deleteButton.addActionListener(listener);
        }
    }
    /**
     * Private nested class to build search student pane.
     * @author Jiaming Xiao
     */
    private class SearchStudentPane {
        /**
         * Constructor.
         */
        private SearchStudentPane() {
            /**
             * Pane for Search Student
             */
            JPanel paneSearchStudents = new JPanel();
            mainPane.add(paneSearchStudents);
            LineBorder lineBorderSearchStudents = new LineBorder(color, 2);
            TitledBorder borderSearchStudents = new TitledBorder(lineBorderSearchStudents, "Search student(s)");
            borderSearchStudents.setTitleColor(color);
            paneSearchStudents.setBorder(borderSearchStudents);
            JPanel searchLine = new JPanel();
            paneSearchStudents.add(searchLine);
            /**
             * Search key label for search student pane.
             */
            JLabel labelSearchKey = new JLabel("Search Key:");
            labelSearchKey.setFont(font);
            labelSearchKey.setVerticalTextPosition(JLabel.CENTER);
            labelSearchKey.setForeground(color);
            paneSearchStudents.add(labelSearchKey);
            searchLine.add(labelSearchKey);
            /**
             * Search key field text for search student pane.
             */
            fieldSearchKey = new JTextField(5);
            searchLine.add(fieldSearchKey);
            /**
             * Search by andrewID button for search student pane.
             */
            searchByAndrewIDButton = new JButton("By Andrew ID");
            searchByAndrewIDButton.setForeground(color);
            paneSearchStudents.add(searchByAndrewIDButton);
            searchLine.add(searchByAndrewIDButton);
            searchByAndrewIDButton.addActionListener(listener);
            /**
             * Search by first name button for search student pane.
             */
            searchByFirstNameButton = new JButton("By First Name");
            searchByFirstNameButton.setForeground(color);
            paneSearchStudents.add(searchByFirstNameButton);
            searchLine.add(searchByFirstNameButton);
            searchByFirstNameButton.addActionListener(listener);
            /**
             * Search by last name button for search student pane.
             */
            searchByLastNameButton = new JButton("By Last Name");
            searchByLastNameButton.setForeground(color);
            paneSearchStudents.add(searchByLastNameButton);
            searchLine.add(searchByLastNameButton);
            searchByLastNameButton.addActionListener(listener);
        }
    }
    /**
     * Private nested class to provide actionPerformed() method to Swing.
     * @author Jiaming Xiao
     */
    private class MyActionListener implements ActionListener {
    /**
     * This function will perform actions of button event.
     * @param event actionevent
     */
     public void actionPerformed(ActionEvent event) {
         if (event.getSource() == addButton) {
             this.addButtonAction();
         }
         if (event.getSource() == deleteButton) {
             this.deleteButtonAction();
         }
         if (event.getSource() == searchByAndrewIDButton) {
             this.searchByAndrewIDAction();
         }
         if (event.getSource() == searchByFirstNameButton) {
             this.searchByFirstNameAction();
         }
         if (event.getSource() == searchByLastNameButton) {
             this.searchByLastNameAction();
         }
         throw new AssertionError("Unknown event.");
     }
     /**
      * This method is built to perform add button action.
      */
     private void addButtonAction() {
         String andrewID, firstName, lastName, phoneNum;
         Student std;
         andrewID = fieldAndrewID.getText();
         firstName = fieldFirstName.getText();
         lastName = fieldLastName.getText();
         phoneNum = fieldPhoneNum.getText();
         if (andrewID.isEmpty()) {
               textAreaResults.append("Error: AndrewID is missing\n");
               return;
         }
         if (firstName.isEmpty()) {
               textAreaResults.append("Error: FirstName is missing\n");
               return;
         }
         if (lastName.isEmpty()) {
               textAreaResults.append("Error: LastName is missing\n");
               return;
         }
         std = studentDirectory.searchByAndrewId(andrewID);
         if (std != null) {
               textAreaResults.append("Student with andrewID " + andrewID + " exist\n");
               std.setFirstName(firstName);
               std.setLastName(lastName);
               std.setPhoneNumber(phoneNum);
               textAreaResults.append("The student's information has been updated:\n");
               textAreaResults.append(std.toString() + "\n");
               return;
         }
         std = new Student(andrewID);
         std.setFirstName(firstName);
         std.setLastName(lastName);
         if (phoneNum != null) {
                std.setPhoneNumber(phoneNum);
         }
         studentDirectory.addStudent(std);
         textAreaResults.append("Add student: " + std.toString() + "\n");
         fieldAndrewID.setText(null);
         fieldFirstName.setText(null);
         fieldLastName.setText(null);
         fieldPhoneNum.setText(null);
     }
     /**
      * This method is built to perform delete button action.
      */
     private void deleteButtonAction() {
        String andrewID = fieldAndrewID.getText();
        Student std;
        andrewID = fieldDelete.getText();
        if (andrewID.isEmpty()) {
              textAreaResults.append("Error: AndrewID is missing\n");
              return;
        }
        std = studentDirectory.searchByAndrewId(andrewID);
        if (std == null) {
              textAreaResults.append("This andrew ID dosen't exist\n");
              return;
        }
        textAreaResults.append("Delete student: " + std.toString() + "\n");
        studentDirectory.deleteStudent(andrewID);
        fieldDelete.setText(null);
     }
     /**
      * This method is built to perform search by andrew Id button action.
      */
     private void searchByAndrewIDAction() {
        String andrewID;
        Student std;
        andrewID = fieldSearchKey.getText();
        if (andrewID.isEmpty()) {
               textAreaResults.append("Error: AndrewID is missing\n");
               return;
        }
        std = studentDirectory.searchByAndrewId(andrewID);
        if (std == null) {
               textAreaResults.append("The student with andrew ID " + andrewID + " doesn't exist!\n");
               return;
        }
        textAreaResults.append("The student with andrew ID " + andrewID + " is found:\n");
        textAreaResults.append(std.toString() + "\n");
        fieldSearchKey.setText(null);
     }
     /**
      * This method is built to perform saerch by first name button action.
      */
     private void searchByFirstNameAction() {
        String firstName;
        firstName = fieldSearchKey.getText();
        if (firstName.isEmpty()) {
               textAreaResults.append("Error: First Name is missing\n");
               return;
        }
        List<Student> stds = studentDirectory.searchByFirstName(firstName);
        System.out.println(stds);
        if (stds.isEmpty()) {
               textAreaResults.append("No student with the first name " + firstName + "\n");
               return;
        }
        textAreaResults.append("The student with first name " + firstName + " is found:\n");
        for (Student s: stds) {
               textAreaResults.append(s.toString() + "\n");
        }
        fieldSearchKey.setText(null);
     }
     /**
      * This method is built to perform search by last name button action.
      */
     private void searchByLastNameAction() {
        String lastName;
        lastName = fieldSearchKey.getText();
        if (lastName.isEmpty()) {
                textAreaResults.append("Error: Last name is missing\n");
                return;
        }
        List<Student> stds = studentDirectory.searchByLastName(lastName);
        if (stds.isEmpty()) {
                textAreaResults.append("No student with last name " + lastName + "\n");
        }
        textAreaResults.append("The student with last name " + lastName + " is found:\n");
        for (Student s: stds) {
                textAreaResults.append(s.toString() + "\n");
        }
        fieldSearchKey.setText(null);
     }
    }
    /**
     * Private nested class to provide keyPerformed() method to Swing.
     * @author Jiaming Xiao
     */
    private class MyKeyListener implements KeyListener {
    /**
     * This function will perform actions of key press event.
     * @param event keyevent
     */
     @Override
     public void keyTyped(KeyEvent event) { }
     @Override
     public void keyPressed(KeyEvent event) {
         if (event.getKeyCode() == KeyEvent.VK_ENTER) {
             System.out.println("I am working\n");
             this.searchByAndrewIDAction();
         }
         throw new AssertionError("Unknown event.");
     }
     @Override
     public void keyReleased(KeyEvent event) { }
     /**
      * This method is built to perform search by andrew Id button action.
      */
     private void searchByAndrewIDAction() {
        String andrewID;
        Student std;
        andrewID = fieldSearchKey.getText();
        if (andrewID.isEmpty()) {
               textAreaResults.append("Error: AndrewID is missing\n");
               return;
        }
        std = studentDirectory.searchByAndrewId(andrewID);
        if (std == null) {
               textAreaResults.append("The student with andrew ID " + andrewID + " doesn't exist!\n");
               return;
        }
        textAreaResults.append("The student with andrew ID " + andrewID + " is found:\n");
        textAreaResults.append(std.toString() + "\n");
        fieldSearchKey.setText(null);
     }
    }
    /**
     * This method is built to extract students info from the csv file.
     * @param stdDir student directory
     * @param fr file reader
     * @throws IOException if the input file doesn't exist.
     */
    private static void loadFile(Directory stdDir, FileReader fr) throws IOException {
         ReadCSV r = new ReadCSV(fr);
         // Define a flag to count the number of lines need to read
         int isEof = 0;
         while (isEof == 0) {
             String[] elements = r.readCSVByLine();
             if (elements != null && elements[0] != "FirstName") {
                 Student std = new Student(elements[2]);
                 std.setFirstName(elements[0]);
                 std.setLastName(elements[1]);
                 if (elements.length > 3) {
                     std.setPhoneNumber(elements[3]);
                 }
                 stdDir.addStudent(std);
             }
             if (elements == null) {
                 isEof = 1;
             }
         }
    }
}
