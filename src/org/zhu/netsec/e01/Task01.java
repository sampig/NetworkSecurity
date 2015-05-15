package org.zhu.netsec.e01;

import java.util.Scanner;

/**
 * All the results of Task01 are running out here.
 * 
 * @author Chenfeng ZHU
 * @see Rot13
 * @see RotN
 *
 */
public class Task01 {

    public static void main(String... strings) {
        Task01 t = new Task01();
        t.partA();
        t.partB();
        t.partC();
        t.partE();
    }

    /**
     * Task A:<br>
     * Encode the text using a ROT13 cipher, and print the resulting ciphertext.
     * 
     * @see Rot13
     */
    public void partA() {
        String plaintext = "The lazy dog plays the xylophone";
        System.out.println("The resulting cipher text using ROT13 is: "
                + Rot13.encrypt(plaintext));
    }

    /**
     * Task B:<br>
     * Encode the text using a ROT23 cipher, and print the resulting ciphertext.
     * 
     * @see Rot13
     */
    public void partB() {
        String plaintext = "The lazy dog plays the xylophone";
        System.out.println("The resulting cipher text using ROT23 is: "
                + Rot13.encrypt_rot23(plaintext));
    }

    /**
     * Task C:<br>
     * Try out all possible rotations of the ROTn cipher, and print them.
     * 
     * @see RotN
     */
    public void partC() {
        String ciphertext = "TSHJFOTQQDXBFLRFSHFRUJIGDFGNQQFGTSL";
        for (int i = 1; i < 26; i++) {
            System.out.println(i + ": " + RotN.decrypt(i, ciphertext));
        }
        System.out.println("Input your choice manually: ");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int num = Integer.parseInt(number);
        System.out.println("The number of rotations: " + num + ", the plain text is :"
                + RotN.decrypt(num, ciphertext));
        scanner.close();
    }

    /**
     * We guess "uif" --> "the". Then we try ROT1 encryption.
     * 
     * @see RotN
     */
    public void partE() {
        String ciphertext = "Uif rvjdl cspxo gpy kvnqt pwfs uif mbaz eph";
        System.out.println("The plain text may be: " + RotN.decrypt(1, ciphertext));
    }

}
