import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
/**
 * The purpose of this class is reading csv files.
 * @author Jiaming Xiao
 */
public class ReadCSV extends BufferedReader {
    /**
     * Constructor.
     * @param in the reader from which to read CSV lines
     */
    public ReadCSV(Reader in) {
        super(in);
    }
    /**
     * This method is to read csv files by line.
     * @return an array of Strings containing the
     * values
     */
    public String[] readCSVByLine() throws IOException {
        // Get single line of file;
        String line = super.readLine();

        // Count the elements in a single line
        int count = 0;

        if(line == null) {
           return null;
        }

        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ',') {
                count+=1;
            }
        }
        
        String[] elements = new String[count+1];
        int startIndex = 0;
        // Get elements
        for(int i = 0; i < count; i++) {
            //Set endIndex
            int endIndex = line.indexOf(',', startIndex);

            if(line.charAt(startIndex) == '"' && 
               line.charAt(endIndex - 1) == '"') {
                //If there are quotes around string
                elements[i] = line.substring(startIndex + 1, endIndex - 1);
            } else {
                //No quotes, just strings
                elements[i] = line.substring(startIndex, endIndex);
            }
            startIndex = endIndex + 1;
        }
        // for the last element
        if(line.charAt(startIndex) == '"' && 
           line.charAt(line.length() - 1) == '"') {
            elements[count] = line.substring(startIndex + 1, line.length() - 1);
        } else {
            elements[count] = line.substring(startIndex, line.length());
        }
        return elements;
    }
}
