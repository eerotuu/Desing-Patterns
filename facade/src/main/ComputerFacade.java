/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;

/**
 *
 * @author Eero
 */
public class ComputerFacade {

    final long BOOT_ADDRESS = 0x4E0;
    final long BOOT_SECTOR = 0x5B;
    final int SECTOR_SIZE = 51;

    private final CPU processor;
    private final Memory ram;
    private final HardDrive hd;

    public ComputerFacade() {
        processor = new CPU();
        ram = new Memory();
        hd = new HardDrive();
    }

    public void start() throws IOException {
        processor.freeze();
        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
    }
}
