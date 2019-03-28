/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.fileprocessor;

import main.reader.Reader;
import main.writer.Writer;

/**
 *
 * @author Eero
 */
public abstract class AbstractFileProcessor implements FileProcessor {

    protected Reader reader;
    protected Writer writer;
    
    @Override
    public String read() {
        return new String(reader.read());
    }

    @Override
    public void write(String s) {
        writer.write(s.getBytes());
    }

    @Override
    public void close() {
        reader.close();
        writer.close();
    }
}
