/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Eero
 */
public class Memory {

    static Map<Long, String> memMap = new HashMap<>();

    public void load(long position, byte[] data) {
        System.out.println("loading : " + String.format("%x", position));
        memMap.put(position, new String(data));
    }
}
