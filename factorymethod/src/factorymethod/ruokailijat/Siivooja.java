/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod.ruokailijat;

import factorymethod.juomat.Juoma;
import factorymethod.juomat.Kotikalja;

/**
 *
 * @author Eero
 */
public class Siivooja extends AterioivaOtus {

    public Juoma createJuoma() {
        return new Kotikalja();
    }

}
