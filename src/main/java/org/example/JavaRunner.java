package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class JavaRunner {

    public static void runJavaCode(String folderPath) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", folderPath);
        Process process = processBuilder.start();
    }
}
