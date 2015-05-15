package org.zhu.netsec.e02;

/**
 * 
 * @author Chenfeng ZHU
 *
 */
public class BirthdayAttacks {

    /**
     * The name of Zodiac signs.
     */
    public static final String[] NAMES_ZODIAC = { "Aries", "Taurus", "Gemini", "Cancer",
            "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius",
            "Pisces" };
    /**
     * The total days of each Zodiac sign.
     */
    public static final int[] DAYS = { 31, 31, 31, 31, 32, 31, 30, 30, 30, 29, 30, 29 };

    /**
     * Calculate the probability that 2 people of num people share the same
     * zodiac.
     * 
     * @param num
     *            total number of people
     * @param type
     *            the type of calculation
     *            <ul>
     *            <li>0: normal distribution</li>
     *            </ul>
     * @return the probability
     */
    public static double calZodiacProbability(int num, int type) {
        if (type == 0) {
            return calZodiacProbabilityNormal(num);
        } else {
            return calZodiacProbability(num);
        }
    }

    public static double calZodiacProbability(int num) {
        return 0.0;
    }

    /**
     * Calculate the probability that 2 people of num people share the same
     * zodiac.
     * 
     * @param num
     *            total number of people
     * @return the probability
     */
    public static double calZodiacProbabilityNormal(int num) {
        double n = NAMES_ZODIAC.length;
        double p = 1.0;
        for (int i = 0; i < num; i++) {
            p *= (n - i) / n;
        }
        p = 1 - p;
        return p;
    }

    /**
     * Calculate the probability that 2 people of num people share the same
     * birthday.
     * 
     * @param num
     *            total number of people
     * @return the probability
     */
    public static double calBirthdayProbability(int num) {
        double n = 365;
        double p = 1.0;
        for (int i = 0; i < num; i++) {
            p *= (n - i) / n;
        }
        p = 1 - p;
        return p;
    }

}
