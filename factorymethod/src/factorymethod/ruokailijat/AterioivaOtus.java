package factorymethod.ruokailijat;

import factorymethod.ruuat.Ruoka;
import factorymethod.juomat.Juoma;

public abstract class AterioivaOtus {

    Juoma juoma = null;
    Ruoka ruoka = null;

    public abstract Juoma createJuoma();

    public void aterioi() {
        syö();
        juo();
    }

    public void syö() {
        if (ruoka != null) {
            System.out.println("Kylläpä " + ruoka + " maistuukin hyvältä");
        } else {
            System.out.println("Kylläpä ruoka maistuukin hyvältä");
        }

    }

    public void juo() {
        if (juoma == null) {
            juoma = createJuoma();
        }
        System.out.println("Aterian jälkeen " + juoma + " tekee terää");
    }
}
