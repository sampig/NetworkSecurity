package org.zhu.netsec.util;

/**
 * 
 * @author Chenfeng Zhu
 *
 */
public class MathUtil {

    public static int x = 0;
    public static int y = 0;
    public static int q = 0;

    /**
     * 
     * @param num
     * @return
     */
    public static int calMinRelativelyPrime(int num) {
        int i = 0;
        for (i = 2; i < num - 1; i++) {
            if (checkRelativelyPrime(num, i)) {
                break;
            }
        }
        return i;
    }

    /**
     * 
     * @param a
     * @param b
     * @return
     */
    public static boolean checkRelativelyPrime(int a, int b) {
        int c = (a > b) ? a : b;
        for (int i = 2; i <= c; i++) {
            if (a % i == 0 && b % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int calEEA(int a, int b) {
        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        } else {
            int tmp = calEEA(b % a, a);
            int i = y;
            y = x;
            x = i - b / a * x;
            return tmp;
        }
    }

    public static void main(String... strings) {
        System.out.println(MathUtil.calEEA(3, 124000));
        System.out.println(MathUtil.x + "," + MathUtil.y);
        System.out.println(MathUtil.checkRelativelyPrime(8, 9));
    }

}
