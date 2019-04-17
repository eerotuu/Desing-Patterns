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
public class CharDataList implements CharData{
    
    private char[] mData;
    
    public CharDataList(char[] aData) {
        this.mData = aData;
    }
    
    @Override
    public void addChars(char[] aData) {
        char[] temp = new char[mData.length + aData.length];
        System.arraycopy(mData, 0, temp, 0, mData.length);
        System.arraycopy(aData, 0, temp, mData.length, aData.length);
        mData = temp;
    }
    
    @Override
    public char[] getData() {
        return mData;
    }
}
