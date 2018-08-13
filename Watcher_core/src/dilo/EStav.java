/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dilo;

/**
 *
 * @author Oldřich
 */
public enum EStav {

    nevideno(0),
    rozkoukano(1),
    videno(2),
    nechci_videt(3);
    private final int stav;

    private EStav(int stav) {
        this.stav = stav;
    }

    public int getStav() {
        return stav;
    }

    @Override
    public String toString() {
        switch (stav) {
            case 0:
                return "Neviděno";
            case 1:
                return "Rozkoukáno";
            case 2:
                return "Viděno";
            case 3:
                return "Nechci vidět";
            default:
                return "chyba výčtu";
        }
    }
}
