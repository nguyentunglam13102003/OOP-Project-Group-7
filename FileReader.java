import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\MSI GF65\\IdeaProjects\\draft2\\userdata.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
    }
}