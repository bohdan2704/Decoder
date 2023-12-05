package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaToTxtConverter {

    public static void execute(String javaFilePath) {
        try {
            convertJavaToTxt(javaFilePath);
            deleteFile(javaFilePath);
            System.out.println("Java file has been converted to text successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while converting the file: " + e.getMessage());
        }
    }

    private static void convertJavaToTxt(String javaFilePath) throws IOException {
        Path inputPath = Paths.get(javaFilePath);
        // Derive the output text file path from the input Java file path
        Path outputPath = Paths.get(inputPath.getParent().toString(), getFileNameWithoutExtension(inputPath) + ".txt");

        // Read the content of the Java file
        byte[] javaFileBytes = Files.readAllBytes(inputPath);
        String javaFileContent = new String(javaFileBytes);

        // Write the content to the text file
        Files.write(outputPath, javaFileContent.getBytes());
    }

    private static String getFileNameWithoutExtension(Path filePath) {
        String fileName = filePath.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }

    public static void deleteFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.delete(path);
    }
}
