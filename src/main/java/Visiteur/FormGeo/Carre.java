package Visiteur.FormGeo;

import Visiteur.Visiteur.IFigureVisitor;

import java.awt.*;

/**
 * Created by frederic on 10/01/2017.
 */
public class Carre extends MyRectangle {

    private int cote;

    public Carre(Point point, int cote, Color backGroundColor, Color boderColor){
        super(point, cote, cote, backGroundColor, boderColor);
        this.cote = cote;
    }

    public int getCote() {
        return cote;
    }

    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append("point= {x = ").append(getPoint().getX())
                .append(" , y = ").append(getPoint().getY()).append("}");
        sb.append(", cote=").append(cote);
        return sb.toString();
    }
}
