package filehandler;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {

    public static void main(String[] args) {

        String fileName = "student.txt";

        try {

            // 1. Create file
            File file = new File(fileName);

            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            // 2. Write data
            FileWriter writer = new FileWriter(file);

            writer.write("Name: Sahithi\n");
            writer.write("Course: B.Tech CSE\n");
            writer.write("Subject: Java\n");

            writer.close();

            System.out.println("Data written successfully.");

            // 3. Read data
            System.out.println("\nFile Content:");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();

            // 4. Append data
            FileWriter appendWriter =
                    new FileWriter(file, true);

            appendWriter.write("Topic: File Handling\n");

            appendWriter.close();

            System.out.println(
                    "\nData appended successfully."
            );

            // 5. Copy file
            FileReader reader =
                    new FileReader("student.txt");

            FileWriter copyWriter =
                    new FileWriter("student_copy.txt");

            int character;

            while ((character = reader.read()) != -1) {
                copyWriter.write(character);
            }

            reader.close();
            copyWriter.close();

            System.out.println(
                    "File copied successfully."
            );

        } catch (IOException e) {

            System.out.println("An error occurred.");

            e.printStackTrace();
        }
    }
}