package org.example;

import java.io.File;

public class Delete {

    public static void deleteFile(String folderPath) {
        try {
            // Create a File object with the folder path and file name
            File fileToDelete = new File(folderPath);

            // Check if the file exists
            if (fileToDelete.exists()) {
                // Attempt to delete the file
                fileToDelete.delete();
//                if (fileToDelete.delete()) {
//                    System.out.println("File '" + folderPath + "' deleted successfully.");
//                } else {
//                    System.out.println("Unable to delete the file '" + folderPath + "'.");
//                }
//            } else {
//                System.out.println("File '" + folderPath + "' not found in the specified folder.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
