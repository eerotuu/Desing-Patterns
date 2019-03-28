/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eero
 */
public class SimpleReader implements Reader {
    
    private FileInputStream inputStream;
    private File inputFile;
      
    public SimpleReader(String fileName) throws FileNotFoundException, IOException {
        inputFile = new File(fileName);
        inputFile.createNewFile();
        inputStream = new FileInputStream(inputFile); 
    }
    
    @Override
    public byte[] read() {
        byte[] bArr  = new byte[(int)inputFile.length()];
        try {
            inputStream.read(bArr);
            return bArr;
        } catch (IOException ex) {
            Logger.getLogger(SimpleReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void close() {
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(SimpleReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
