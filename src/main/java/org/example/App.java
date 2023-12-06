package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    private static final String KEY = "419DD6D9EDA10AFCD7BB10BCDA124AE89";
    private static final String jarFileName = "\\Spacing.jar";

    public static final String curDirPath =SystemDirectory.getCurrentDirectory();
    public static final String fileNameTxt = "src/main/java/org/example/Main.txt";


    public static void main(String[] args) throws Exception {
        // MAKE THIS WITH CHANGING THE EXTENSION !!! MAYBE
        String content = ReadFileToString.execute(curDirPath+jarFileName);

//        String encryptString = LicenseGenerator.Encrypt(ReadFileToString.execute(curDirPath+jarFileName), KEY);
//        System.out.println(encryptString);

//        String decryptedString = LicenseDecoder.Decrypt(encryptString, KEY);
        WriteStringToFile.execute(curDirPath+jarFileName, content);
//        System.out.println(decryptedString);

    }
}