package Visiteur.FormGeo;

import Visiteur.Visiteur.IFigureVisitor;

import java.awt.*;

/**
 * Created by frederic on 10/01/2017.
 */
public class MyRectangle extends AFormeGéométrique {

    private int longeur;
    private int largeur;

    public MyRectangle(Point point, int longeur, int largeur){
        super(point, new Rectangle(longeur, largeur));
        this.longeur = longeur;
        this.largeur = largeur;
    }

    public int getLongeur() {
        return longeur;
    }

    public int getLargeur() {
        return largeur;
    }


    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(super.toString());
        sb.append(", longeur=").append(longeur);
        sb.append(", largeur=").append(largeur);
        return sb.toString();
    }
}
