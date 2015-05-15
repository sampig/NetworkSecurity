package org.zhu.netsec.e01;

/**
 * OneTimePads provides
 * 
 * @author Chenfeng ZHU
 *
 */
public class OneTimePads {

    /**
     * Encrypt the plaintext with the OTP.<br/>
     * The plaintext could be text or HEX code; and the pad could also be text
     * or HEX code.
     * 
     * @param plaintext
     *            the plain text
     * @param pad
     *            the OTP
     * @param type
     *            types of the text
     * @return the ciphertext (in HEX)
     */
    public static String encrypt(String plaintext, String pad, int type) {
        String ciphertext = "";
        switch (type) {
        case T_P_HEX_C_HEX:
            break;
        case T_P_TEXT_C_TEXT:
            // Convert plaintext and cipher into binary strings.
            plaintext = toASCII(plaintext);
            pad = toASCII(pad);
            break;
        case T_P_TEXT_C_HEX:
            // Convert plaintext into binary strings.
            plaintext = toASCII(plaintext);
            break;
        case T_P_HEX_C_TEXT:
            // Convert cipher into binary strings.
            pad = toASCII(pad);
            break;
        default:
            break;
        }
        ciphertext = encrypt(plaintext, pad);
        return ciphertext;
    }

    /**
     * Encrypt plaintext(in HEX) with Pad(in HEX)
     * 
     * @param plaintext
     *            the plain text in HEX
     * @param pad
     *            the pad in HEX
     * @return the cipher text in HEX
     */
    private static String encrypt(String plaintext, String pad) {
        String ciphertext = "";
        StringBuffer sb = new StringBuffer();
        plaintext = plaintext.replaceAll(" ", "");
        pad = pad.replaceAll(" ", "");
        if (plaintext.length() > pad.length()) {
            System.out.println("Pad's length must be larger than plaintext's length!");
            return null;
        }
        for (int i = 1; i < plaintext.length(); i += 2) {
            char c1 = plaintext.charAt(i - 1);
            char c2 = plaintext.charAt(i);
            String ch1 = c1 + "" + c2;
            char c3 = pad.charAt(i - 1);
            char c4 = pad.charAt(i);
            String ch2 = c3 + "" + c4;
            String xor = BitOperation.operationXOR(
                    Integer.toBinaryString(Integer.valueOf(ch1, 16)),
                    Integer.toBinaryString(Integer.valueOf(ch2, 16)));
            sb.append(Integer.toHexString(Integer.valueOf(xor, 2)));
        }
        ciphertext = sb.toString();
        return ciphertext;
    }

    /**
     * Decrypt ciphertext(in HEX) with Pad(in HEX)
     * 
     * @param ciphertext
     *            the ciphertext in HEX
     * @param pad
     *            the pad in HEX
     * @return the plain text in HEX
     */
    public static String decrypt(String ciphertext, String pad) {
        String plaintext = "";
        plaintext = encrypt(ciphertext, pad);
        return plaintext;
    }

    /**
     * Convert text into ASCII (in HEX).
     * 
     * @param string
     *            text
     * @return the strings of ASCII (in HEX)
     */
    public static String toASCII(String string) {
        String ascii = "";
        StringBuffer sb = new StringBuffer();
        char[] ch = string.toCharArray();
        for (char c : ch) {
            sb.append(Integer.toHexString((int) c) + " ");
        }
        ascii = sb.substring(0, sb.length() - 1);
        return ascii;
    }

    /**
     * Convert ASCII into text.
     * 
     * @param string
     *            the text of ASCII (in Hex)
     * @return the plain text
     */
    public static String toText(String string, String delimiter) {
        String text = "";
        StringBuffer sb = new StringBuffer();
        String[] ch = null;
        if (delimiter == null || "".equals(delimiter)) {
            ch = new String[string.length() / 2];
            for (int i = 1; i < string.length(); i += 2) {
                ch[(i - 1) / 2] = string.substring(i - 1, i + 1);
            }
        } else {
            ch = string.split(delimiter);
        }
        for (String c : ch) {
            sb.append((char) Integer.valueOf(c, 16).intValue());
        }
        text = sb.toString();
        return text;
    }

    public final static int T_P_HEX_C_HEX = 0;
    public final static int T_P_TEXT_C_TEXT = 1;
    public final static int T_P_TEXT_C_HEX = 2;
    public final static int T_P_HEX_C_TEXT = 3;

    public static void main(String... strings) {
        String str = "Bob will you marry me?";
        System.out.println(toASCII(str));
        str = "42 6f 62 20 77 69 6c 6c 20 79 6f 75 20 6d 61 72 72 79 20 6d 65 3f";
        System.out.println(toText(str, " "));
        System.out.println('a' + 'c');
        System.out.println('a' + "" + 'c');
    }

}
