package org.zhu.netsec.e03;

/**
 * All the results of Task02 are running out here.
 * 
 * @author Chenfeng ZHU
 * @see DiffieHellman
 *
 */
public class Task02 {

    public static void main(String... strings) {
        Task02 t = new Task02();
        t.partA();
    }

    /**
     * This include Part A, B and C.
     */
    public void partA() {
        int p = 19, g = 5;
        System.out.println("p=" + p + " ,g=" + g);
        int sa = 2;
        int sb = 3;
        DiffieHellman dh = new DiffieHellman(p, g);
        dh.setSa(sa);
        dh.setSb(sb);
        System.out.println("Ta=" + dh.calTa());
        System.out.println("Tb=" + dh.calTb());
        System.out.println("They share the secret number from the {0, " + (p - 1)
                + "} range: " + dh.calSharedKey());
    }

}
