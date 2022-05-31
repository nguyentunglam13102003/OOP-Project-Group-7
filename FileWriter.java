import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class FileWriter {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scan.next();

        System.out.print("Age: ");
        int age = scan.nextInt();

        System.out.println("Name: " + name + "\n" + "Age: " + age);
        scan.close();

        try {
            File file = new File("userdata.txt");
            PrintWriter writer = new PrintWriter(file);
            writer.write("Name: " + name + "\n" + "Age: " + age);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}