import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


// This is the same file reader I used in the previous assignments. Isn't it still versatile?
public class FileReader {

    public static ArrayList<String> readFile(String path) {
        ArrayList<String> output = new ArrayList<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(!line.equals("")) {                  // Checks if the line is empty.
                    if(line.charAt(0) != '#' && line.charAt(0) != ',') {         // Checks if the line starts with #
                        output.add(line);               // Adds the line otherwise.
                    }

                }
            }
            scanner.close();
            return output;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

}