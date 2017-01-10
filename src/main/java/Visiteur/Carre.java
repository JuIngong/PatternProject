package Visiteur;

import java.awt.*;

/**
 * Created by frederic on 10/01/2017.
 */
public class Carre extends MyRectangle{

    private int cote;

    public Carre(Point point, int cote){
        super(point, cote, cote);
        this.cote = cote;
    }

    public int getCote() {
        return cote;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(", ");
        sb.append("cote=").append(cote);
        return sb.toString();
    }
}
