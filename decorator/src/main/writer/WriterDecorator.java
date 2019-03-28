/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.writer;

/**
 *
 * @author Eero
 */
public abstract class WriterDecorator implements Writer {
    
    protected Writer writer;
    
    public WriterDecorator(Writer w){
        writer = w;
    }
    
    @Override
    public void write(byte[] bArr) {
        writer.write(bArr);
    }
    
    @Override
    public void close() {
        writer.close();
    }
}
