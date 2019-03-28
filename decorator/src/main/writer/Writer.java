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
public interface Writer {
    abstract public void write(byte[] bArr);
    abstract public void close();
}
