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
public interface Reader {
    abstract public byte[] read();
    abstract public void close();
}
