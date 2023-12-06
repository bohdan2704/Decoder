package org.example;

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
}
