package org.zhu.netsec.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * FileManager is a Utility to manage file.
 * 
 * @author Chenfeng ZHU
 *
 */
public class FileManager {

    private String path = "";
    // private String filename = "";
    private File file;
    private String encoding = "UTF-8";

    public FileManager() {
    }

    public FileManager(String filepath) {
        this.path = Class.class.getResource(filepath).getPath();
        file = new File(path);
    }

    public FileManager(URI uri) {
        this.path = uri.getPath();
        file = new File(uri);
    }

    /**
     * Get all content in the file and store them in <code>StringBuffer</code>.
     * 
     * @return all content (in StringBuffer)
     */
    public StringBuffer readBuffer() {
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, encoding);
            BufferedReader in = new BufferedReader(isr);
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
                // System.out.println(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    /**
     * Get all content in the file and store them in an array.
     * 
     * @return all content (in byte[])
     */
    public byte[] readByte() {
        byte[] b = null;
        FileInputStream fis = null;
        DataInputStream din = null;
        try {
            fis = new FileInputStream(file);
            din = new DataInputStream(fis);
            b = new byte[(int) file.length()];
            din.read(b);
            if (din != null) {
                din.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 
     * @param filepath
     * @return
     */
    public boolean setPath(String filepath) {
        this.path = Class.class.getResource(filepath).getPath();
        file = new File(path);
        return file.exists();
    }

    /**
     * 
     * @param encoding
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * 
     * @return
     */
    public File getFile() {
        return file;
    }

}
