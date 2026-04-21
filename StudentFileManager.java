import java.io.*;
import java.util.Scanner;

public class StudentFileManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String fileName = "students.txt";

        try {

            File file = new File(fileName);

            // Create file if it does not exist
            if (file.createNewFile()) {
                System.out.println("New file created: " + fileName);
            } else {
                System.out.println("File already exists.");
            }

            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter mode (append/overwrite): ");
            String mode = sc.nextLine();

            FileWriter fw;

            if (mode.equalsIgnoreCase("append"))
                fw = new FileWriter(fileName, true);
            else
                fw = new FileWriter(fileName);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details of student " + i);

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("ID: ");
                String id = sc.nextLine();

                System.out.print("Grade: ");
                String grade = sc.nextLine();

                bw.write(name + " , " + id + " , " + grade);
                bw.newLine();
            }

            bw.close(); // closing file after writing

            // Reading and displaying records
            System.out.println("\n----- Student Records -----");

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }

        sc.close();
    }
}
