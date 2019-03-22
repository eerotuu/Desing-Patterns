/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory;

import abstractfactory.outfitfactory.*;

/**
 *
 * @author Eero
 */
public class Main {

    public static void main(String[] args) {
        
        OutfitFactory factory = new AdidasOutfitFactory();
        Outfit myOutfit = new Outfit();
        myOutfit.createOutfit(factory);
        System.out.println(myOutfit+"\n");
        
        factory = new BossOutfitFactory();
        myOutfit.createOutfit(factory);
        System.out.println(myOutfit);
    }
}
