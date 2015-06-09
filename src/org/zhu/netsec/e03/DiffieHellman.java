package org.zhu.netsec.e03;

/**
 * Diffie-Hellman Key Exchange is a predecessor of public key cryptography.
 * 
 * @author Chenfeng ZHU
 *
 */
public class DiffieHellman {

    // a prime number
    private int p = 3;
    // a factor
    private int g = 0;

    private int sa = 0;
    private int sb = 0;

    public DiffieHellman() {
    }

    public DiffieHellman(int p, int g) {
        super();
        this.p = p;
        this.g = g;
    }

    /**
     * T = g^s mod p
     * 
     * @param s
     *            personal secret
     * @return
     */
    public int calT(int s) {
        int t = ((int) Math.pow(g, s)) % p;
        return t;
    }

    /**
     * Ta = g^sa mod p
     * 
     * @return
     */
    public int calTa() {
        int ta = ((int) Math.pow(g, sa)) % p;
        return ta;
    }

    /**
     * Tb = g^sb mod p
     * 
     * @return
     */
    public int calTb() {
        int tb = ((int) Math.pow(g, sb)) % p;
        return tb;
    }

    /**
     * s = Tb^Sa mod p | s = Ta^Sb mod p
     * 
     * @return
     */
    public int calSharedKey() {
        int sk = ((int) Math.pow(this.calTb(), sa)) % p;
        return sk;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getSa() {
        return sa;
    }

    public void setSa(int sa) {
        this.sa = sa;
    }

    public int getSb() {
        return sb;
    }

    public void setSb(int sb) {
        this.sb = sb;
    }

}
