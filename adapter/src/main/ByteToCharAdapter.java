/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Eero
 */
public class ByteToCharAdapter implements CharData {

    private ByteData byteData;
    
    public ByteToCharAdapter(ByteData b) {
        byteData = b;
    }
    
    @Override
    public void addChars(char[] aData) {
        byteData.addBytes(new String(aData).getBytes());
    }

    @Override
    public char[] getData() {
        return new String(byteData.getData()).toCharArray();
    }
}
