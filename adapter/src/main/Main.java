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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ByteData bData = new ByteDataList("abc".getBytes());
        bData.addBytes("defg".getBytes());
        
        CharData toCharAdapter = new ByteToCharAdapter(bData);
        toCharAdapter.addChars("hijklmn".toCharArray());
        System.out.println(toCharAdapter.getData());
        
        
        
        CharData cData = new CharDataList("abc".toCharArray());
        cData.addChars("defg".toCharArray());
        
        ByteData toByteAdapter = new CharToByteAdapter(cData);
        toByteAdapter.addBytes("hijklmn".getBytes());
        System.out.println(new String(toByteAdapter.getData()));      
    }    
}
