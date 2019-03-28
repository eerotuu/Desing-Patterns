/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import main.fileprocessor.FileProcessor;
import main.fileprocessor.SecureFileProcessor;
import main.fileprocessor.SimpleFileProcessor;

/**
 *
 * @author Eero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // delete file since i've set writer to write at the end of file.
        File file = new File("file.txt");
        if(file.exists()) file.delete();
        
        String data = "Lorem Ipsum is simply dummy text of the printing and\n"
                + "typesetting industry. Lorem Ipsum has been the industry's\n"
                + "standard dummy text ever since the 1500s, when an unknown\n"
                + "printer took a galley of type and scrambled it to make a type\n"
                + "specimen book. It has survived not only five centuries, but\n"
                + "also the leap into electronic typesetting, remaining\n"
                + "essentially unchanged. It was popularised in the 1960s with\n"
                + "the release of Letraset sheets containing Lorem Ipsum\n"
                + "passages, and more recently with desktop publishing software\n"
                + "like Aldus PageMaker including versions of Lorem Ipsum.";
        
        // write and read file contents using secure writer and reader
        FileProcessor fp = new SecureFileProcessor("file.txt");
        fp.write(data);
        System.out.println(fp.read());
        fp.close();
        
        System.out.println("==========================");
        
        // change to simple writer and reader.
        // write at the end of encrpyted data and print the file contents.
        fp = new SimpleFileProcessor("file.txt");
        fp.write("\nHmmmm....");
        System.out.println(fp.read());
        fp.close();
        
        System.out.println("==========================");
        
        // read() returns here string 'could not decrypt file'(SimpleWriter.java:51)
        // since I added data at the end of encrypted data and data length 
        // must be multiple of 16 when decrypting with padded cipher
        fp = new SecureFileProcessor("file.txt");
        System.out.println(fp.read());
    }
}
