import java.util.Scanner;
import java.io.File;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Huffman code");

        // String text = "aaabbbaaa";

        Scanner scan = null;
        try {
            scan = new Scanner(new File("Huffman.java"));
        } catch (Exception e) {
            System.out.println("Failed to read file");
            System.exit(0);
        }

        StringBuilder builder = new StringBuilder();
        while (scan.hasNextLine()) {
            builder.append(scan.nextLine());
            builder.append("\n");
        }
        String text = builder.toString();
        

        HuffmanNode root = Huffman.textToTree(text);
        String encoded = Huffman.encode(root, text);
        String decoded = Huffman.decode(root, encoded);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);



    }
}