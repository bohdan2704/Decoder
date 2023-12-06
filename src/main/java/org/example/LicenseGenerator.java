package org.example;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;

public class LicenseGenerator
{
//    private static final String KEY = "419DD6D9EDA10AFCD7BB10BCDA124AE89";


    public static String Encrypt(String plainText, String key) throws Exception {
        final Key a = createKey(getBytes(key));
        final Cipher instance = Cipher.getInstance("AES");
        instance.init(Cipher.ENCRYPT_MODE, a);

        byte[] cipherText = instance.doFinal(plainText.getBytes());
        String oText = DatatypeConverter.printHexBinary(cipherText);

        return oText;
    }

    public static byte[] getBytes(final String s) {
        if (s.length() < 1) {
            return null;
        }

        final byte[] array = new byte[s.length() / 2];
        for (int i = 0; i < s.length() / 2; ++i) {
            int idx = i * 2;
            String s1 = s.substring(idx, idx + 1);
            String s2 = s.substring(idx + 1, idx + 2);

            int nb1 = Integer.parseInt(s1, 16);
            int nb2 = Integer.parseInt(s2, 16);
            int total = nb1 * 16 + nb2;

            array[i] = (byte)(total);
        }

        return array;
    }

    public static Key createKey(final byte[] key) throws Exception {
        return new SecretKeySpec(key, "AES");
    }
}