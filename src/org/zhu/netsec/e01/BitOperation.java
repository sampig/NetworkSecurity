package org.zhu.netsec.e01;

/**
 * BitOperation provides the operations below:
 * <ul>
 * <li>AND</li>
 * <li>OR</li>
 * <li>XOR</li>
 * <li>NOT</li>
 * </ul>
 * 
 * @author Chenfeng ZHU
 *
 */
public class BitOperation {

    /**
     * The XOR operation in bit.
     * 
     * @param value1
     *            the first value (binary number)
     * @param value2
     *            the second value (binary number)
     * @return the result (string of binary number)
     */
    public static String operationXOR(String value1, String value2) {
        String result = "";
        StringBuffer sb = new StringBuffer();
        int l1 = value1.length();
        int l2 = value2.length();
        // if the two string do NOT have the same length,
        // add "0" in front of the string to make their length equal.
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                value2 = "0" + value2;
            }
        } else if (l1 < l2) {
            for (int i = 0; i < l2 - l1; i++) {
                value1 = "0" + value1;
            }
        }
        for (int i = 0; i < value1.length(); i++) {
            short s1 = Short.parseShort(value1.substring(i, i + 1));
            short s2 = Short.parseShort(value2.substring(i, i + 1));
            sb.append(s1 ^ s2);
        }
        result = sb.toString();
        return result;
    }

    /**
     * Convert a binary number into a decimal number.
     * 
     * @param binary
     *            the binary number
     * @return a decimal number
     */
    public static String binaryToDecimal(String binary) {
        String decimal = "";
        double result = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                result = result + Math.pow(2, binary.length() - i - 1);
            }
        }
        decimal = String.valueOf(result);
        return decimal;
    }

    /**
     * A quick way to calculate the XOR result with the common functionalities.
     * 
     * @param value1
     *            the first value (binary number)
     * @param value2
     *            the second value (binary number)
     * @return the result (string of binary number)
     */
    public static String operationXOR_short(String value1, String value2) {
        int l1 = Integer.parseInt(value1, 2);
        int l2 = Integer.parseInt(value2, 2);
        return Integer.toBinaryString(l1 ^ l2);
    }

    /**
     * The XOR operation in bit for multiple numbers.
     * 
     * @param value
     *            strings of binary number
     * @return the result (string of binary number)
     */
    public static String operationXOR(String[] value) {
        String result = operationXOR(value[0], value[1]);
        for (int i = 2; i < value.length; i++) {
            result = operationXOR(result, value[i]);
        }
        return result;
    }

    /**
     * The AND operation in bit for multiple numbers.
     * 
     * @param value
     *            strings of binary number
     * @return the result (string of binary number)
     */
    public static String operationAND(String[] value) {
        String result = operationALL(value[0], value[1], OP_AND);
        for (int i = 2; i < value.length; i++) {
            result = operationALL(result, value[i], OP_AND);
        }
        return result;
    }

    /**
     * The OR operation in bit for multiple numbers.
     * 
     * @param value
     *            strings of binary number
     * @return the result (string of binary number)
     */
    public static String operationOR(String[] value) {
        String result = operationALL(value[0], value[1], OP_OR);
        for (int i = 2; i < value.length; i++) {
            result = operationALL(result, value[i], OP_OR);
        }
        return result;
    }

    /**
     * The NOT operation in bit for one number.
     * 
     * @param value
     *            string of binary number
     * @return the result (string of binary number)
     */
    public static String operationNOT(String value) {
        String result = operationALL(value, "", OP_NOT);
        return result;
    }

    /**
     * Type of operation could be:
     * <ul>
     * <li>BitOperation.OP_AND</li>
     * <li>BitOperation.OP_OR</li>
     * <li>BitOperation.OP_XOR</li>
     * <li>BitOperation.OP_NOT</li>
     * </ul>
     * If it is NOT operation, value2 can be empty string.
     * 
     * @param value1
     *            the first value (binary number)
     * @param value2
     *            the second value (binary number)
     * @param type
     *            type of operation
     * @return the result (string of binary number)
     */
    private static String operationALL(String value1, String value2, int type) {
        String result = "";
        StringBuffer sb = new StringBuffer();
        int l1 = value1.length();
        int l2 = value2.length();
        // if the two string do NOT have the same length,
        // add "0" in front of the string to make their length equal.
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                value2 = "0" + value2;
            }
        } else if (l1 < l2) {
            for (int i = 0; i < l2 - l1; i++) {
                value1 = "0" + value1;
            }
        }
        for (int i = 0; i < value1.length(); i++) {
            // boolean b1 = value1.charAt(i) == '1' ? true : false;
            // boolean b2 = value2.charAt(i) == '1' ? true : false;
            short s1 = Short.parseShort(value1.substring(i, i + 1));
            short s2 = Short.parseShort(value2.substring(i, i + 1));
            switch (type) {
            case OP_AND:
                sb.append(s1 & s2);
                break;
            case OP_OR:
                sb.append(s1 | s2);
                break;
            case OP_XOR:
                sb.append(s1 ^ s2);
                break;
            case OP_NOT:
                sb.append(s1 ^ 1);
                break;
            default:
                break;
            }
        }
        result = sb.toString();
        return result;
    }

    private final static int OP_AND = 0;
    private final static int OP_OR = 1;
    private final static int OP_XOR = 2;
    private final static int OP_NOT = 3;

    public static void main(String... strings) {
        String str1 = "100101001";
        String str2 = "101110101";
        String[] str = { "100101001", "101110101" };
        String result = operationXOR_short(str1, str2);
        System.out.println("operationXOR_short: " + result);
        System.out.println("Decimal: " + binaryToDecimal(result));
        for (String s : str) {
            System.out.print(s + ", ");
        }
        System.out.println();
        System.out.println("operationAND: " + operationAND(str));
        System.out.println("operationOR: " + operationOR(str));
        System.out.println("operationXOR: " + operationXOR(str));
        System.out.println("operationNOT: " + operationNOT(str[0]));
    }

}
