package org.zhu.netsec.e02;

import org.zhu.netsec.util.StringUtil;

/**
 * All the results of Task01 are running out here.
 * 
 * @author Chenfeng ZHU
 * @see DESUtil
 *
 */
public class Task01 {

    public static void main(String... strings) {
        Task01 t = new Task01();
        System.out.println("=====Part D: ");
        t.partD();
        System.out.println("\n=====Part E: ");
        t.partE();
    }

    /**
     * 
     */
    public void partD() {
        String key_original = "6A4EE13E7F9ADD10";
        int size = 8;
        String key_valid = DESUtil.validateDESKey(key_original, size);
        System.out.println(key_valid.toUpperCase());
    }

    /**
     * 
     */
    public void partE() {
        String cipherhex = "BE55649305934135";
        String keyhex = "F1FE9EB0838FFE";
        String plaintext = "NetSec15";
        String plainhex = StringUtil.convertTextToHex(plaintext);
        byte[] cipherbyte = new byte[] { (byte) 0xBE, (byte) 0x55, (byte) 0x64, (byte) 0x93,
                (byte) 0x05, (byte) 0x93, (byte) 0x41, (byte) 0x35 };
        byte[] keybyte = new byte[] { (byte) 0xF1, (byte) 0xFE, (byte) 0x9E, (byte) 0xB0,
                (byte) 0x83, (byte) 0x8F, (byte) 0xFE, (byte) 0x01 };
        byte[] plainbyte = StringUtil.convertHexToBytes(plainhex);
        for (int i = 0; i < 256; i++) {
            String key = keyhex + String.format("%02x", i);
            // System.out.println(key);
            String plain = DESUtil.decrypt(cipherhex, key);
            if (plainhex.equalsIgnoreCase(plain)) {
                System.out.println("====================" + key);
            }
        }
        // decryption
        for (int i = 0; i < 256; i++) {
            keybyte[7] = (byte) i;
            byte[] plainbyte1 = DESUtil.decrypt(cipherbyte, keybyte);
            String plain = StringUtil.convertBytesToHex(plainbyte1);
            System.out.println(StringUtil.convertBytesToHex(keybyte) + ": " + plain + ", "
                    + StringUtil.convertHexToText(plain) + ", " + new String(plainbyte1));
            if (plainhex.equalsIgnoreCase(plain)) {
                System.out.println("====================" + i);
            }
        }
        // encryption
        for (int i = 0; i < 256; i++) {
            keybyte[7] = (byte) i;
            byte[] cipherbyte1 = DESUtil.encrypt(plainbyte, keybyte);
            String cipher = StringUtil.convertBytesToHex(cipherbyte1);
            if (cipherhex.equalsIgnoreCase(cipher)) {
                System.out.println("====================" + i);
                System.out.println(StringUtil.convertBytesToHex(cipherbyte));
            }
        }
    }

}
