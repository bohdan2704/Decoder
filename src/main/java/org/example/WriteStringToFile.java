package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class WriteStringToFile {
    public static void execute(String filePath, String contentToWrite) {
        // Replace "YourJavaFile.java" with the desired path and filename

        try {
            writeStringToFile(filePath, contentToWrite);
            System.out.println("String has been written to the file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    private static void writeStringToFile(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, content.getBytes());
    }
}
