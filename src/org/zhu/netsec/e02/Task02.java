package org.zhu.netsec.e02;

/**
 * All the results of Task02 are running out here.
 * 
 * @author Chenfeng ZHU
 *
 */
public class Task02 {

    public static void main(String... strings) {
        Task02 t = new Task02();
        t.partA();
    }

    /**
     * Calculate the probability.
     */
    public void partA() {
        System.out.println(BirthdayAttacks.calZodiacProbability(2, 0));
    }

}
