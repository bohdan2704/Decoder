package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    private static final String KEY = "419DD6D9EDA10AFCD7BB10BCDA124AE89";
    public static final String fileName = "src/main/java/org/example/Main.java";
    public static final String fileNameTxt = "src/main/java/org/example/Main.txt";


    public static void main(String[] args) throws Exception {
        // MAKE THIS WITH CHANGING THE EXTENSION !!! MAYBE

        String encryptString = LicenseGenerator.Encrypt(ReadFileToString.execute(fileName), KEY);
        WriteStringToFile.execute(fileName, encryptString);
        JavaToTxtConverter.execute(fileName);

        String decryptString = LicenseDecoder.Decrypt(ReadFileToString.execute(fileNameTxt), KEY);
        WriteStringToFile.execute(fileNameTxt, decryptString);
        TxtToJavaConverter.execute(fileNameTxt);

    }
}