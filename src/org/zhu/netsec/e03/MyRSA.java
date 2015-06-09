package org.zhu.netsec.e03;

import org.zhu.netsec.util.MathUtil;

/**
 * 
 * @author Chenfeng ZHU
 *
 */
public class MyRSA {

    // two primes
    private int p = 3;
    private int q = 5;

    public MyRSA() {
    }

    public MyRSA(int p, int q) {
        super();
        this.p = p;
        this.q = q;
    }

    /**
     * n = p * q
     * 
     * @return
     */
    public int calN() {
        int n = p * q;
        return n;
    }

    /**
     * t = (p-1) * (q-1)
     * 
     * @return
     */
    public int calTotient() {
        int t = (p - 1) * (q - 1);
        return t;
    }

    /**
     * 
     * @return
     */
    public int getE() {
        int e = 0;
        int t = this.calTotient();
        e = MathUtil.calMinRelativelyPrime(t);
        return e;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

}
