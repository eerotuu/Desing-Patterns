package factorymethod;

import factorymethod.ruokailijat.AterioivaOtus;
import factorymethod.ruokailijat.Opiskelija;
import factorymethod.ruokailijat.Opettaja;
import factorymethod.ruokailijat.Siivooja;
import factorymethod.ruuat.NakitJaMuusi;
import factorymethod.ruuat.Ruoka;

public class Main {

    public static void main(String[] args) {

        Ruoka päivänRuoka = new NakitJaMuusi();

        AterioivaOtus opettaja = new Opettaja();
        opettaja.aterioi();

        System.out.println("");

        AterioivaOtus opiskelija = new Opiskelija(päivänRuoka);
        opiskelija.aterioi();

        System.out.println("");

        AterioivaOtus siivooja = new Siivooja();
        siivooja.aterioi();

    }
}
