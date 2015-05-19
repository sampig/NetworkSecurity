package org.zhu.netsec.e02;

import org.zhu.netsec.util.StringUtil;

/**
 * All the results of Task01 are running out here.
 * 
 * @author Chenfeng ZHU
 * @see DESUtil
 * @see StringUtil
 *
 */
public class Task01 {

    public static void main(String... strings) {
        Task01 t = new Task01();
        System.out.println("=====Part D=====");
        t.partD();
        System.out.println("\n=====Part E=====");
        t.partE();
    }

    /**
     * Part D: validate the DES key.
     */
    public void partD() {
        String key_original = "6A4EE13E7F9ADD10";
        int size = 8;
        String key_valid = DESUtil.validateDESKey(key_original, size);
        System.out.println(key_valid.toUpperCase());
    }

    /**
     * Use the method of "brute force" to decrypt the cipher text and find out
     * the key.
     */
    public void partE() {
        String cipherhex = "BD5A679C09994C3A";
        String keyhex = "F1FE9EB0838FFE";
        String plaintext = "NetSec15";
        String plainhex = StringUtil.convertTextToHex(plaintext);
        byte[] cipherbyte = new byte[] { (byte) 0xBD, (byte) 0x5A, (byte) 0x67, (byte) 0x9C,
                (byte) 0x09, (byte) 0x99, (byte) 0x4C, (byte) 0x3A };
        byte[] keybyte = new byte[] { (byte) 0xF1, (byte) 0xFE, (byte) 0x9E, (byte) 0xB0,
                (byte) 0x83, (byte) 0x8F, (byte) 0xFE, (byte) 0x01 };
        byte[] plainbyte = StringUtil.convertHexToBytes(plainhex);
        // decryption
        for (int i = 0; i < 256; i++) {
            String key = keyhex + String.format("%02x", i);
            String plain = DESUtil.decrypt(cipherhex, key);
            if (plainhex.equalsIgnoreCase(plain)) {
                System.out.println("HEX (string): " + key + " ("
                        + DESUtil.validateDESKey(key, 8) + ")");
            }
        }
        // decryption
        for (int i = 0; i < 256; i++) {
            keybyte[7] = (byte) i;
            byte[] plainbyte1 = DESUtil.decrypt(cipherbyte, keybyte);
            String plain = StringUtil.convertBytesToHex(plainbyte1);
            if (plainhex.equalsIgnoreCase(plain)) {
                System.out.println("HEX (bytes): " + Integer.toHexString(i));
            }
        }
        // encryption
        for (int i = 0; i < 256; i++) {
            keybyte[7] = (byte) i;
            byte[] cipherbyte1 = DESUtil.encrypt(plainbyte, keybyte);
            String cipher = StringUtil.convertBytesToHex(cipherbyte1);
            if (cipherhex.equalsIgnoreCase(cipher)) {
                System.out.print("====================" + Integer.toHexString(i));
                String str = StringUtil.convertBytesToHex(keybyte);
                System.out.println(", key: " + str + " (" + DESUtil.validateDESKey(str, 8)
                        + ")");
            }
        }
    }

}
