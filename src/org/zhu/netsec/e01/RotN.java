package org.zhu.netsec.e01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <code>RotN</code> provides all kinds of ROT.
 * 
 * @author Chenfeng ZHU
 *
 */
public class RotN {

    /**
     * Constants store all lowercase characters which are used for mapping.
     */
    private static final char[] ALPHABET_LO = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    /**
     * Constants store all uppercase characters which are used for mapping.
     */
    private static final char[] ALPHABET_UP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * Get all mappings for encryption, and store them in a Map.
     * 
     * @param n
     *            the number of rotation
     * @return a Map for encryption mapping
     */
    public static Map<Character, Character> getEncryptMap(int n) {
        if (n < 1) {
            System.out.println("");
            return null;
        } else if (n > 25) {
            // if n is more than 25, we don't need to rotate so many times.
            n = 299 % 26;
        }
        Map<Character, Character> map = new HashMap<>(0);
        for (int i = 0, j = n; i < 26; i++, j++) {
            if (j >= ALPHABET_LO.length) {
                j = 0;
            }
            map.put(ALPHABET_LO[i], ALPHABET_LO[j]);
            map.put(ALPHABET_UP[i], ALPHABET_UP[j]);
        }
        return map;
    }

    /**
     * 
     * @param n
     * @return
     */
    public static Map<Character, Character> getDecryptMap(int n) {
        if (n < 1 || n > 25) {
            n = 299 % 26;
        }
        Map<Character, Character> map = new HashMap<>(0);
        for (int i = 0, j = n; i < 26; i++, j++) {
            if (j >= ALPHABET_LO.length) {
                j = 0;
            }
            map.put(ALPHABET_LO[j], ALPHABET_LO[i]);
            map.put(ALPHABET_UP[j], ALPHABET_UP[i]);
        }
        return map;
    }

    public static String encrypt(int n, String plaintext) {
        String ciphertext = "";
        StringBuffer sb = new StringBuffer();
        Map<Character, Character> map = getEncryptMap(n);
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(map.get(c));
            } else {
                sb.append(" ");
            }
        }
        ciphertext = sb.toString();
        return ciphertext;
    }

    public static String decrypt(int n, String ciphertext) {
        String plaintext = "";
        StringBuffer sb = new StringBuffer();
        Map<Character, Character> map = getDecryptMap(n);
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(map.get(c));
            } else {
                sb.append(" ");
            }
        }
        plaintext = sb.toString();
        return plaintext;
    }

    public static void main(String... strings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your choice: ");
        String choice = scanner.nextLine();
        if ("1".equalsIgnoreCase(choice)) {
            System.out.println("Encryption.");
            System.out.println("Input plain text: ");
            String str = "";
            str = scanner.nextLine();
            if (str == null || "".equalsIgnoreCase(str)) {
                str = "The lazy dog plays the xylophone";
            }
            System.out.println("Input n(1~25): ");
            String num = "";
            num = scanner.nextLine();
            int n = Integer.parseInt(num);
            if (n < 1 || n > 25) {
                n = 1;
                System.out.println("Error. Default value of n: 1");
            }
            System.out.println(RotN.encrypt(n, str));
        } else if ("2".equalsIgnoreCase(choice)) {
            System.out.println("Decryption.");
            System.out.println("Input encrypted text: ");
            String str = "";
            str = scanner.nextLine();
            if (str == null || "".equalsIgnoreCase(str)) {
                str = "TSHJFOTQQDXBFLRFSHFRUJIGDFGNQQFGTSL";
            }
            for (int i = 1; i < 26; i++) {
                System.out.println(i + ":" + RotN.decrypt(i, str));
            }
        } else if ("3".equalsIgnoreCase(choice)) {
            System.out.println("Decryption.");
            System.out.println("Input encrypted text: ");
            String str = "";
            // str = scanner.nextLine();
            if (str == null || "".equalsIgnoreCase(str)) {
                str = "Gur ynml qbt cynlf gur klybcubar";
            }
            System.out.println(299 + ":" + RotN.decrypt(299, str));
        }
        scanner.close();
    }
}
