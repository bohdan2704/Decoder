package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class JavaRunner {

    public static void runJavaCode(String folderPath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", folderPath);
            Process process = processBuilder.start();

            // Wait for the process to finish
            int exitCode = process.waitFor();

            // Optionally, you can check the exit code
            if (exitCode == 0) {
                System.out.println("Process completed successfully");
            } else {
                System.err.println("Process exited with an error: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
