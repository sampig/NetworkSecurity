package org.zhu.netsec.e02;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.zhu.netsec.util.StringUtil;

/**
 * 
 * @author Chenfeng ZHU
 *
 */
public class DESUtil {

    /**
     * Validate DES key, and return the correct one.
     * 
     * @param des_key
     *            DES key (in HEX)
     * @param block_size
     * @return valid DES key (in HEX)
     */
    public static String validateDESKey(String des_key, int block_size) {
        StringBuffer sb = new StringBuffer();
        if (block_size == 0) {
            block_size = 8;
        }
        int size = block_size / 4;
        for (int i = size; i <= des_key.length(); i += size) {
            String str_byte = des_key.substring(i - size, i);
            String str_bi = Long.toBinaryString(Long.valueOf(str_byte, 16));
            // System.out.println(": " + str_byte);
            boolean f = true;
            char[] ch = str_bi.toCharArray();
            for (char c : ch) {
                if (c == '1') {
                    f = !f;
                }
            }
            if (f) {
                int l = ch.length;
                int b = Character.getNumericValue(ch[l - 1]);
                ch[l - 1] = (char) (b ^ 1 + '0');
                // System.out.println(Character.getNumericValue(ch[l - 1]));
            }
            sb.append(String.format("%02x", (Long.valueOf(new String(ch), 2))).toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 
     * <ul>
     * <li>AES/CBC/NoPadding (128)</li>
     * <li>AES/CBC/PKCS5Padding (128)</li>
     * <li>AES/ECB/NoPadding (128)</li>
     * <li>AES/ECB/PKCS5Padding (128)</li>
     * <li>DES/CBC/NoPadding (56)</li>
     * <li>DES/CBC/PKCS5Padding (56)</li>
     * <li>DES/ECB/NoPadding (56)</li>
     * <li>DES/ECB/PKCS5Padding (56)</li>
     * <li>DESede/CBC/NoPadding (168)</li>
     * <li>DESede/CBC/PKCS5Padding (168)</li>
     * <li>DESede/ECB/NoPadding (168)</li>
     * <li>DESede/ECB/PKCS5Padding (168)</li>
     * <li>RSA/ECB/PKCS1Padding (1024, 2048)</li>
     * <li>RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)</li>
     * <li>RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)</li>
     * </ul>
     * 
     * @param plaintext
     * @param key
     * @return
     */
    public static String encrypt(String plaintext, String key) {
        byte[] plainbyte = StringUtil.convertHexToBytes(plaintext);
        byte[] keybyte = StringUtil.convertHexToBytes(key);
        byte[] cipherbyte = encrypt(plainbyte, keybyte);
        String ciphertext = StringUtil.convertBytesToHex(cipherbyte);
        return ciphertext;
    }

    public static byte[] encrypt(byte[] plainbyte, byte[] keybyte) {
        byte[] cipherbyte = null;
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DES");
            DESKeySpec keyspec = new DESKeySpec(keybyte);
            SecretKey skey = keyfactory.generateSecret(keyspec);
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            cipherbyte = cipher.doFinal(plainbyte);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return cipherbyte;
    }

    /**
     * 
     * @param ciphertext
     *            (in HEX)
     * @param key
     *            (in HEX)
     * @return plaintext (in HEX)
     * @see StringUtil
     */
    public static String decrypt(String ciphertext, String key) {
        byte[] cipherbyte = StringUtil.convertHexToBytes(ciphertext);
        byte[] keybyte = StringUtil.convertHexToBytes(key);
        byte[] plainbyte = decrypt(cipherbyte, keybyte);
        String plaintext = StringUtil.convertBytesToHex(plainbyte);
        return plaintext;
    }

    /**
     * 
     * @param cipherbyte
     * @param keybyte
     * @return
     */
    public static byte[] decrypt(byte[] cipherbyte, byte[] keybyte) {
        byte[] plainbyte = null;
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DES");
            DESKeySpec keyspec = new DESKeySpec(keybyte);
            SecretKey skey = keyfactory.generateSecret(keyspec);
            cipher.init(Cipher.DECRYPT_MODE, skey);
            plainbyte = cipher.doFinal(cipherbyte);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return plainbyte;
    }

}
