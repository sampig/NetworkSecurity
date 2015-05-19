package org.zhu.netsec.util;

/**
 * A utility for string.
 * 
 * @author Chenfeng ZHU
 *
 */
public class StringUtil {

    /**
     * Convert Text to Hex.
     * 
     * @param text
     * @return Hex String (Upper Case)
     */
    public static String convertTextToHex(String text) {
        char[] chars = text.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char ch : chars) {
            sb.append(String.format("%02x", (int) ch).toUpperCase());
            // Integer.toHexString((int) ch);
        }
        return sb.toString();
    }

    /**
     * Convert Hex to Text.
     * 
     * @param hex
     * @return
     */
    public static String convertHexToText(String hex) {
        StringBuilder sb = new StringBuilder();
        // hex string split into two characters
        for (int i = 0; i < hex.length() - 1; i += 2) {
            String str = hex.substring(i, (i + 2));
            int ch = Integer.parseInt(str, 16);
            sb.append((char) ch);
        }
        return sb.toString();
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    /**
     * Convert bytes array to Hex string.
     * 
     * @param bytes
     * @return string (in HEX)
     */
    public static String convertBytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * Convert Hex string to byte array.
     * 
     * @param hex
     * @return byte array
     */
    public static byte[] convertHexToBytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character
                    .digit(hex.charAt(i + 1), 16));
        }
        return bytes;
    }

    public static void main(String... strings) {
        System.out.println(StringUtil.convertTextToHex("\n\t"));
        System.out.println(StringUtil.convertHexToText("BE55649305934135"));
        System.out.println(StringUtil.convertHexToText("F1FE9EB0838FFE"));
        System.out.println(StringUtil.convertTextToHex("¾UdA5"));
        System.out.println(StringUtil.convertTextToHex("NetSec15"));
        System.out.println(StringUtil.convertBytesToHex("NetSec15".getBytes()));
    }

}
