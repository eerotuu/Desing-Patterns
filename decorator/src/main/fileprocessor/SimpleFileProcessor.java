/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.fileprocessor;

import java.io.FileNotFoundException;
import java.io.IOException;
import main.reader.SimpleReader;
import main.writer.SimpleWriter;

/**
 *
 * @author Eero
 */
public class SimpleFileProcessor extends AbstractFileProcessor {
  
    public SimpleFileProcessor(String fileName) throws FileNotFoundException, IOException {
        super.reader = new SimpleReader(fileName);
        super.writer = new SimpleWriter(fileName);
    }    
}
