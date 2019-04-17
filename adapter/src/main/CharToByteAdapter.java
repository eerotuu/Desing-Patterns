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
public class CharToByteAdapter implements ByteData{

    private CharData charData;
    
    public CharToByteAdapter(CharData c) {
        charData = c;
    }
    
    @Override
    public void addBytes(byte[] aData) {
        charData.addChars(new String(aData).toCharArray());
    }

    @Override
    public byte[] getData() {
        return new String(charData.getData()).getBytes();
    }
    
}
