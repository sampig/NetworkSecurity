package org.zhu.netsec.e01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.zhu.netsec.util.FileManager;

/**
 * All the results of Task04 are running out here.
 * 
 * @author Chenfeng ZHU
 * @see CharFrequency
 * @see FileManager
 * @see Monoalphabetic
 *
 */
public class Task04 {

    public static void main(String... strings) {
        Task04 t = new Task04();
        t.partA();
        t.partB();
        System.out.println();
        t.partC();
        System.out.println();
        t.partD();
    }

    private Map<Character, Integer> mapCounter = new HashMap<>(0);
    private List<CharFrequency> listFrequency = new ArrayList<>(0);
    private Map<Character, Double> mapFrequency = new HashMap<>(0);
    private Map<Character, String> mapPercent = new HashMap<>(0);
    private int sumCounter = 0;

    /**
     * Clear all collections and initialize.
     */
    private void init() {
        mapCounter.clear();
        mapFrequency.clear();
        listFrequency.clear();
        mapPercent.clear();
        sumCounter = 0;
    }

    /**
     * Calculate the occurrence frequencies of characters in a file.
     * 
     * @param filename
     *            the whole path of the file
     */
    public void calculateFrequency(String filename) {
        this.init();
        FileManager fm = new FileManager();
        if (fm.setPath(filename)) {
            StringBuffer sb = fm.readBuffer();
            String text = sb.toString().toLowerCase();
            text = text.replace("ä", "a").replace("ö", "o").replace("ü", "u")
                    .replace("ß", "ss");
            // Count the total occurrence of each character.
            for (Character c : text.toCharArray()) {
                if (c < 'a' || c > 'z') {
                    continue;
                }
                Integer count = mapCounter.get(c);
                mapCounter.put(c, (count == null ? 1 : count + 1));
                sumCounter++;
            }
            // Calculate the probabilities.
            Iterator<Map.Entry<Character, Integer>> entries = mapCounter.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<Character, Integer> entry = entries.next();
                Character c = entry.getKey();
                Integer count = entry.getValue();
                Double d = count * 100.0 / sumCounter;
                mapFrequency.put(c, d);
                CharFrequency cf = new CharFrequency(c, d);
                listFrequency.add(cf);
                mapPercent.put(c, ((int) (count * 100000.0 / sumCounter)) / 1000.0 + "%");
            }
        }
    }

    /**
     * Calculate the occurrence frequencies of characters in the book
     * "<i>Siddhartha</i>" in German.
     */
    public void partA() {
        String filepath1 = "/resources/text/2499-8.txt";
        this.init();
        this.calculateFrequency(filepath1);
        System.out.println("Siddhartha: ");
        System.out.println("Counts: " + mapCounter);
        System.out.println("Percentages: " + mapPercent);
        // System.out.println(mapFrequency);
    }

    /**
     * Based on Task04.partA(). Sort the occurrence frequencies in descending
     * order.
     */
    public void partB() {
        // System.out.println(listFrequency);
        Collections.sort(listFrequency, Collections.reverseOrder());
        System.out.println("Order: " + listFrequency);
    }

    /**
     * Calculate the occurrence frequencies of characters in the book
     * "<i>The Critique of Pure Reason</i>" in English. And sort them.
     */
    public void partC() {
        String filepath2 = "/resources/text/pg4280.txt";
        this.init();
        this.calculateFrequency(filepath2);
        System.out.println("The Critique of Pure Reason: ");
        System.out.println("Count: " + mapCounter);
        System.out.println("Percentage: " + mapPercent);
        Collections.sort(listFrequency, Collections.reverseOrder());
        System.out.println("Order: " + listFrequency);
    }

    /**
     * Decryption based on the occurrence frequencies of letters in a given
     * language.
     */
    public void partD() {
        String filepath3 = "/resources/text/challenge.txt";
        this.init();
        this.calculateFrequency(filepath3);
        System.out.println("The cipher text: ");
        System.out.println("Count: " + mapCounter);
        System.out.println("Percentage: " + mapPercent);
        Collections.sort(listFrequency, Collections.reverseOrder());
        System.out.println("Order: " + listFrequency);
    }

}
