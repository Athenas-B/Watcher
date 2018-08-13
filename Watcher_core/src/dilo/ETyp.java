/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dilo;

/**
 *
 * @author Oldřich
 */
public enum ETyp {

    Serial(0),
    Anime(1),
    Film(2);
    private final int typ;

    private ETyp(int typ) {
        this.typ = typ;
    }

    public int getTyp() {
        return typ;
    }

    @Override
    public String toString() {
        switch (typ) {
            case 0:
                return "Seriál";
            case 1:
                return "Anime";
            case 2:
                return "Film";
            default:
                return "chyba výčtu";

        }
    }
}
