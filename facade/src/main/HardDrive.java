/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Eero
 */
public class HardDrive {

    public byte[] read(long lba, int size) throws FileNotFoundException, IOException {
        File file = new File("src/main/data.txt");
        FileInputStream input = new FileInputStream(file);
        byte[] b = new byte[(int) file.length()];
        input.read(b);
        byte[] r = new byte[size];
        System.arraycopy(b, (int) lba, r, 0, size);
        return r;
    }
}
