package org.zhu.netsec.e01;

import java.util.HashMap;
import java.util.Map;

import org.zhu.netsec.util.FileManager;

/**
 * Monoalphabetic is used to store the character mapping for encryption and
 * decryption.
 * 
 * @author Chenfeng Zhu
 *
 */
public class Monoalphabetic {

    private Map<Character, Character> mapEncryption = new HashMap<>(0);
    private Map<Character, Character> mapDecryption = new HashMap<>(0);

    public Map<Character, Character> getEncryptionMap() {
        return mapEncryption;
    }

    public Map<Character, Character> getDecryptionMap(int type) {
        Map<Character, Character> mapDecryption = new HashMap<>(0);
        if (type == LANG_DE) {
            mapDecryption.put('a', 'e');
            mapDecryption.put('b', 'n');
            mapDecryption.put('c', 'i');
            mapDecryption.put('d', 'r');
            mapDecryption.put('e', 'a');
            mapDecryption.put('f', 't');
            mapDecryption.put('g', 's');
            mapDecryption.put('h', 'd');
            mapDecryption.put('i', 'h');
            mapDecryption.put('j', 'u');
            mapDecryption.put('k', 'l');
            mapDecryption.put('l', 'o');
            mapDecryption.put('m', 'c');
            mapDecryption.put('n', 'g');
            mapDecryption.put('o', 'm');
            mapDecryption.put('p', 'b');
            mapDecryption.put('q', 'f');
            mapDecryption.put('r', 'w');
            mapDecryption.put('s', 'p');
            mapDecryption.put('t', 'k');
            mapDecryption.put('u', 'v');
            mapDecryption.put('v', 'z');
            mapDecryption.put('w', 'j');
            mapDecryption.put('x', 'y');
            mapDecryption.put('y', 'q');
            mapDecryption.put('z', 'x');
        } else if (type == LANG_EN) {
            mapDecryption.put('a', 'e');
            mapDecryption.put('b', 't');
            mapDecryption.put('c', 'i');
            mapDecryption.put('d', 'n');
            mapDecryption.put('e', 'o');
            mapDecryption.put('f', 'a');
            mapDecryption.put('g', 's');
            mapDecryption.put('h', 'r');
            mapDecryption.put('i', 'h');
            mapDecryption.put('j', 'c');
            mapDecryption.put('k', 'l');
            mapDecryption.put('l', 'd');
            mapDecryption.put('m', 'u');
            mapDecryption.put('n', 'f');
            mapDecryption.put('o', 'p');
            mapDecryption.put('p', 'm');
            mapDecryption.put('q', 'y');
            mapDecryption.put('r', 'g');
            mapDecryption.put('s', 'b');
            mapDecryption.put('t', 'w');
            mapDecryption.put('u', 'v');
            mapDecryption.put('v', 'x');
            mapDecryption.put('w', 'j');
            mapDecryption.put('x', 'k');
            mapDecryption.put('y', 'q');
            mapDecryption.put('z', 'z');
        }
        this.mapDecryption = mapDecryption;
        return this.mapDecryption;
    }

    public final static int LANG_EN = 1;
    public final static int LANG_DE = 2;

    public static void main(String... strings) {
        String filename = "/resources/text/challenge.txt";
        FileManager fm = new FileManager();
        String text = "Qdcahdcmi Rckiako Kjhrcn Kacmiiedhf red acb hajfgmiad Abfhamtad, Vllklna, Plfebctad jbh Nalklna. Ad rjdha eo 23. Ltflpad 1813 cb Gepdlhf (gsefad Ldfgfack ulb Fejmia) napldab jbh uadgfedp uadojfkcmi 1848 cb Vabfdekejgfdekcab.";
        if (fm.setPath(filename)) {
            text = fm.readBuffer().toString().toLowerCase();
        }
        text="Icadlbwojg Axsahcfclbab yahlmi hjdmizjadab";
        System.out.println(text);
        StringBuffer sb = new StringBuffer();
        Monoalphabetic m = new Monoalphabetic();
        Map<Character, Character> map = m.getDecryptionMap(Monoalphabetic.LANG_DE);
        for (char c : text.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(map.get(c));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        // sb = new StringBuffer();
        // map = m.getDecryptionMap(Monoalphabetic.LANG_EN);
        // for (char c : text.toLowerCase().toCharArray()) {
        // if (c >= 'a' && c <= 'z') {
        // sb.append(map.get(c));
        // } else {
        // sb.append(c);
        // }
        // }
        // System.out.println(sb.toString());
    }

}
