/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod.ruokailijat;

import factorymethod.ruuat.Ruoka;
import factorymethod.juomat.Juoma;
import factorymethod.juomat.ViruValge;

/**
 *
 * @author Eero
 */
public class Opiskelija extends AterioivaOtus {
    
    public Opiskelija() {
        super();
    }
    
    public Opiskelija(Ruoka ruoka) {
        super.ruoka = ruoka;
    }

    public Juoma createJuoma() {
        return new ViruValge();
    }

}
