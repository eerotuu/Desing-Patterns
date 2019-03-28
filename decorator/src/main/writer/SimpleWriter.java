/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eero
 */
public class SimpleWriter implements Writer {

    private FileOutputStream outputStream;

    // FileOutputStream append set true.
    public SimpleWriter(String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        file.createNewFile();
        outputStream = new FileOutputStream(file, true);
    }

    @Override
    public void write(byte[] bArr) {
        if (bArr != null) {
            try {
                outputStream.write(bArr);
            } catch (IOException ex) {
                Logger.getLogger(SimpleWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void close() {
        try {
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(SimpleWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
