package org.zhu.netsec.e01;

import java.util.Scanner;

/**
 * <code>Rot13</code> provided methods:
 * <ul>
 * <li>Encryption with Rot13</li>
 * <li>Decryption with Rot13</li>
 * <li>Encryption with Rot23</li>
 * <li>Decryption with Rot23</li>
 * </ul>
 * 
 * @author Chenfeng ZHU
 *
 */
public class Rot13 {

    /**
     * Encrypt the plain text using ROT13.
     * 
     * @param plaintext
     *            the plain text
     * @return the cipher text
     */
    public static String encrypt(String plaintext) {
        String ciphertext = "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) {
                // for the character between a and m, just rotate directly.
                c += 13;
            } else if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) {
                // for the character between n and z, it would out of bound.
                // then there would be a loop: c = c + 13 -26.
                c -= 13;
            }
            sb.append(c);
        }
        ciphertext = sb.toString();
        return ciphertext;
    }

    /**
     * Encrypt the plain text using ROT23.
     * 
     * @param plaintext
     *            the plain text
     * @return the cipher text
     */
    public static String encrypt_rot23(String plaintext) {
        String ciphertext = "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if ((c >= 'a' && c <= 'c') || (c >= 'A' && c <= 'C')) {
                c += 23;
            } else if ((c >= 'd' && c <= 'z') || (c >= 'D' && c <= 'Z')) {
                // c = c +23 - 26
                c -= 3;
            }
            sb.append(c);
        }
        ciphertext = sb.toString();
        return ciphertext;
    }

    /**
     * Decrypt the cipher text using ROT13.
     * 
     * @param ciphertext
     *            the cipher text
     * @return the plain text
     */
    public static String decrypt(String ciphertext) {
        String plaintext = "";
        // for rot13, the operation of encryption is the same as the decrytion.
        plaintext = encrypt(ciphertext);
        return plaintext;
    }

    /**
     * Decrypt the cipher text using ROT23.
     * 
     * @param ciphertext
     *            the cipher text
     * @return the plain text
     */
    public static String decrypt_rot23(String ciphertext) {
        String plaintext = "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if ((c >= 'a' && c <= 'w') || (c >= 'A' && c <= 'W')) {
                c += 3;
            } else if ((c >= 'x' && c <= 'z') || (c >= 'X' && c <= 'Z')) {
                c -= 23;
            }
            sb.append(c);
        }
        ciphertext = sb.toString();
        return plaintext;
    }

    public static void main(String... strings) {
        System.out.println("Input: ");
        Scanner scanner = new Scanner(System.in);
        String str = "";
        str = scanner.nextLine();
        if (str == null || "".equalsIgnoreCase(str)) {
            str = "The lazy dog plays the xylophone";
        }
        System.out.println("Rot13: " + Rot13.encrypt(str));
        System.out.println("Rot23: " + Rot13.encrypt_rot23(str));
        scanner.close();
    }

}
