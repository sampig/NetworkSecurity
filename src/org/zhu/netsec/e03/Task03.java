package org.zhu.netsec.e03;

/**
 * All the results of Task03 are running out here.
 * 
 * @author Chenfeng ZHU
 * @see MyRSA
 *
 */
public class Task03 {

    public static void main(String... strings) {
        Task03 t = new Task03();
        t.partB();
        t.partC();
        t.partD();
    }

    /**
     * 
     */
    public void partB() {
        int p = 311, q = 401;
        System.out.println("p=" + p + " ,q=" + q);
        MyRSA rsa = new MyRSA(p, q);
        System.out.println("n=" + rsa.calN());
        System.out.println("totient=" + rsa.calTotient());
        System.out.println("e=" + rsa.getE());
    }

    public void partC() {
        ;
    }

    public void partD() {
        int n = 124711;
        System.out.println("log2(124711-1)=" + Math.log(n - 1) / Math.log(2));
    }

}
