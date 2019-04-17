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
public class ByteDataList implements ByteData {
    
    private byte[] mData;
    
    public ByteDataList(byte[] aData) {
        this.mData = aData;
    }
    
    @Override
    public void addBytes(byte[] aData) {
        byte[] temp = new byte[mData.length + aData.length];
        System.arraycopy(mData, 0, temp, 0, mData.length);
        System.arraycopy(aData, 0, temp, mData.length, aData.length);
        mData = temp;
    }
    
    @Override
    public byte[] getData() {
        return mData;
    }
}
