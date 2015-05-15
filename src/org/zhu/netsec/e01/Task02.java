package org.zhu.netsec.e01;

/**
 * All the results of Task02 are running out here.
 * 
 * @author Chenfeng ZHU
 * @see BitOperation
 *
 */
public class Task02 {

    public static void main(String... strings) {
        Task02 t = new Task02();
        t.partC();
    }

    /**
     * Compute the XOR value and print it in binary and decimal.
     */
    public void partC() {
        String str1 = "100101001";
        String str2 = "101110101";
        String binary = BitOperation.operationXOR(str1, str2);
        System.out.println("XOR: " + binary);
        System.out.println("Decimal: " + BitOperation.binaryToDecimal(binary));
        System.out.println("Check: " + (297 ^ 373));
    }

}
