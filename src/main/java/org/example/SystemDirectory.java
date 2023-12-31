package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SystemDirectory {

    public static String get() {
        String systemHomeDirectory = System.getProperty("user.home");

        System.out.println("System Home Directory: " + systemHomeDirectory);
        return systemHomeDirectory;
    }

    public static String getCurrentDirectory() {
        String currentDirectory = System.getProperty("user.dir");

        System.out.println("Current Directory: " + currentDirectory);
        return currentDirectory;
    }

    public static void createFolder(String folderPath) {
        try {
            Files.createDirectories(Paths.get(folderPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
