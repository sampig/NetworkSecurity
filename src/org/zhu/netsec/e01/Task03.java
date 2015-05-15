package org.zhu.netsec.e01;

/**
 * All the results of Task03 are running out here.
 * 
 * @author Chenfeng ZHU
 * @see OneTimePads
 *
 */
public class Task03 {

    public static void main(String... strings) {
        Task03 t = new Task03();
        t.partA();
        t.partB();
    }

    private String pad = "2806b1caf89723b3308033a58837075b52e10da1dd68ac75c060211155803a3e";
    private String plaintext = "Bob will you marry me?";

    /**
     * Encrypt the plain text with OTP.
     */
    public void partA() {
        String ciphertext = OneTimePads.encrypt(plaintext, pad, OneTimePads.T_P_TEXT_C_HEX);
        System.out.println("Ciphertext in HEX: " + ciphertext);
        System.out.println("Ciphertext: " + OneTimePads.toText(ciphertext, ""));
        String plaintext2 = OneTimePads.decrypt(ciphertext, pad);
        System.out.println("Plaintext: " + OneTimePads.toText(plaintext2, ""));
    }

    /**
     * Decrypt the cipher text with the wrong OTP.
     */
    public void partB() {
        String ciphertext = OneTimePads.encrypt(plaintext, pad, OneTimePads.T_P_TEXT_C_HEX);
        String pad2 = "253d8399af9f3dba309830a7c923150953fd4eb9ca32";
        String plaintext2 = OneTimePads.decrypt(ciphertext, pad2);
        System.out.println("Plaintext in HEX: " + plaintext2);
        System.out.println("Plaintext: " + OneTimePads.toText(plaintext2, ""));
    }

}
