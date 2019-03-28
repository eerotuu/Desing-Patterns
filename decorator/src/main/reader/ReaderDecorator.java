/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.reader;

/**
 *
 * @author Eero
 */
public abstract class ReaderDecorator implements Reader {
    
    private Reader reader;
    
    public ReaderDecorator(Reader r) {
        reader = r;
    }
        
    @Override
    public byte[] read() {
        return reader.read();
    }

    @Override
    public void close() {
        reader.close();
    }
}
