package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class Delete {

    public static void deleteFolder(String deleteFolder) {
        try {
            deleteFolderHelpful(Paths.get(deleteFolder));
            System.out.println("Folder deleted successfully.");
        } catch (IOException e) {
            System.err.println("Error deleting folder: " + e.getMessage());
        }
    }

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

    private static void deleteFolderHelpful(Path folderPath) throws IOException {
        if (Files.exists(folderPath)) {
            Files.walkFileTree(folderPath, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    // Handle the case where the visit of a file fails (optional)
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }
}
