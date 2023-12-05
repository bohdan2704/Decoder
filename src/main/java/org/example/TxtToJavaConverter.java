package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TxtToJavaConverter {

    public static void execute(String txtFilePath) {
        try {
            convertTxtToJava(txtFilePath);
            JavaToTxtConverter.deleteFile(txtFilePath);
            System.out.println("Text file has been converted to Java successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while converting the file: " + e.getMessage());
        }
    }

    private static void convertTxtToJava(String txtFilePath) throws IOException {
        Path inputPath = Paths.get(txtFilePath);

        // Derive the output Java file path from the input text file path
        Path outputPath = Paths.get(inputPath.getParent().toString(), getFileNameWithoutExtension(inputPath) + ".java");

        // Read the content of the text file
        byte[] txtFileBytes = Files.readAllBytes(inputPath);
        String txtFileContent = new String(txtFileBytes);

        // Write the content to the Java file
        Files.write(outputPath, txtFileContent.getBytes());
    }

    private static String getFileNameWithoutExtension(Path filePath) {
        String fileName = filePath.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }
}
