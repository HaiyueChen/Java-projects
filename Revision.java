import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Revision
 */

public class Revision {

    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("Hello " + name + "!");

        System.out.print("Select a file to open: ");
        String file_name = s.nextLine();
        Scanner file_scanner = null;;
        try {
            File f = new File(file_name);
            file_scanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found, exiting");
            System.exit(0);
        }

        System.out.println("The contents of the file: \n");
        while (file_scanner.hasNext()) {
            System.out.println(file_scanner.nextLine());
        }

        
    }
}