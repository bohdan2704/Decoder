package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class ReadFileToString {
    public static String execute(String filePath) {

        try {
            String fileContent = readFileToString(filePath);
            System.out.println("File content:\n" + fileContent);
            return fileContent;

        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static String readFileToString(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes);
    }
}
