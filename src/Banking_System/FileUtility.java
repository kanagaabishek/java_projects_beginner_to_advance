package Banking_System;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {
    public static void clearFile(String filename) {
        try (FileWriter fw = new FileWriter(filename, false)) {
            fw.write("");
            System.out.println("File cleared successfully!");
        } catch (IOException e) {
            System.out.println("Error clearing file: " + e.getMessage());
        }
    }
}

