
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class ExternalSortTester {

    /**
     * Generates a file where there are n random integers (one per line) in the
     * range from 0 to 300. You can use this file to test your external sort.
     */
    public static void generateLargeFile(String filename, int n) {
        Random rand = new Random();
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (int i = 0; i < n; i++)
                pw.println(rand.nextInt(300));
        } catch (IOException e) {
            System.out.println("Error writing to a file " + filename);
        }

    }

    public static void main(String[] args) {
        generateLargeFile("inputFile", 1000000);
        
    }

}
