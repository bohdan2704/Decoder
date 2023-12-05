package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class JavaRunner {

    public static void runJavaCode(String folderPath, String javaFileName) throws IOException, InterruptedException {
        String javaFilePath = folderPath + File.separator + javaFileName;

        // Build the command to run the Java code
        ProcessBuilder processBuilder = new ProcessBuilder("java", javaFileName);
        processBuilder.directory(new File(folderPath));

        // Redirect output to the console
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

        // Start the process
        Process process = processBuilder.start();

        // Wait for the process to complete
        int exitCode = process.waitFor();
        System.out.println("Java code executed with exit code: " + exitCode);
    }

    public static void main(String[] args) {
        try {
            // Replace "path/to/your/folder" and "YourJavaFile.java" with the actual folder and Java file names
            runJavaCode("src/main/java/org/example", "Main.java");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
