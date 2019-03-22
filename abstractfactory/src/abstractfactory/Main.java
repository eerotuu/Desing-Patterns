/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory;

import abstractfactory.outfitfactory.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eero
 */
public class Main {

    public static void main(String[] args) {

        OutfitFactory factory = new AdidasOutfitFactory();
        Outfit myOutfit = new Outfit();
        myOutfit.createOutfit(factory);
        System.out.println(myOutfit + "\n");

        factory = new BossOutfitFactory();
        myOutfit.createOutfit(factory);
        System.out.println(myOutfit);

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("src/abstractfactory/factory.properties"));
            Class cl = Class.forName("abstractfactory.outfitfactory."
                    + prop.getProperty("factory"));
            factory = (OutfitFactory) cl.newInstance();
            myOutfit.createOutfit(factory);
            System.out.println("\n" + myOutfit);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
