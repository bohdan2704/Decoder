package org.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Scanner;

public class JarEncryptor {
    static String inputJarPath = SystemDirectory.getCurrentDirectory() + "\\Spacing.jar";
    static String encryptedJarPath = SystemDirectory.getCurrentDirectory() + "\\encrypted.jar";
    static String decryptedJarPath = SystemDirectory.get() + "\\SystemFiles\\decrypted.jar";
    static String folderInSystemDirectory = SystemDirectory.get() + "\\SystemFiles";

    public static void main(String[] args) {

//        System.out.println(encrypt());
        decrypt();
    }

    private static void decrypt() {
        // Generate a random AES key
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter license key: ");
        String licenseKeyInString = scanner.nextLine();
        licenseKeyInString = licenseKeyInString.replace("\n", "");

        SecretKey secretKey = stringToSecretKey(licenseKeyInString);
        // Decrypt the JAR file
        SystemDirectory.createFolder(folderInSystemDirectory);
        decryptJar(encryptedJarPath, decryptedJarPath, secretKey);
        JavaRunner.runJavaCode(decryptedJarPath);
        Delete.deleteFile(decryptedJarPath);
    }

    public static String encrypt() {
        SecretKey secretKey = generateSecretKey();
        // Encrypt the JAR file
        encryptJar(inputJarPath, encryptedJarPath, secretKey);
        assert secretKey != null;
        return secretKeyToString(secretKey);
    }

    public static String secretKeyToString(SecretKey secretKey) {
        byte[] encodedKey = secretKey.getEncoded();
        return Base64.getEncoder().encodeToString(encodedKey);
    }

    public static SecretKey stringToSecretKey(String encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return new javax.crypto.spec.SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    private static SecretKey generateSecretKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128); // 128-bit key size
            return keyGenerator.generateKey();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private static void encryptJar(String inputJarPath, String encryptedJarPath, SecretKey secretKey) {
        try {
            byte[] inputBytes = Files.readAllBytes(Path.of(inputJarPath));
            byte[] encryptedBytes = performEncryption(inputBytes, secretKey);

            Files.write(Path.of(encryptedJarPath), encryptedBytes, StandardOpenOption.CREATE);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void decryptJar(String encryptedJarPath, String decryptedJarPath, SecretKey secretKey) {
        try {
            byte[] encryptedBytes = Files.readAllBytes(Path.of(encryptedJarPath));
            byte[] decryptedBytes = performDecryption(encryptedBytes, secretKey);
            System.out.println(new String(decryptedBytes));
            Files.write(Path.of(decryptedJarPath), decryptedBytes, StandardOpenOption.CREATE);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static byte[] performEncryption(byte[] inputBytes, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(inputBytes);
    }

    private static byte[] performDecryption(byte[] encryptedBytes, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedBytes);
    }
}
