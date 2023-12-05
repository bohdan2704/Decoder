package org.example;

public class SystemDirectory {

    public static void get() {
        String systemHomeDirectory = System.getProperty("user.home");

        System.out.println("System Home Directory: " + systemHomeDirectory);
    }
}
