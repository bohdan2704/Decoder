package org.example;// RunJarFromFolder.java
import java.io.File;
import java.io.IOException;

public class RunJar {
    public static void runJarFromFolder(String folderPath, String jarFileName) throws IOException {
        // Assuming the JAR file is named MyJar.jar
        String jarFilePath = folderPath + File.pathSeparator + jarFileName;
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarFilePath);
        processBuilder.directory(new java.io.File(folderPath));
        Process process = processBuilder.start();

        // You can add additional code here if needed
    }

}
