package Visiteur.FormGeo;

import Visiteur.Visiteur.IFigureVisitor;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class Ellipse extends AFormeGéométrique {
    private int largeur;
    private int hauteur;

    public Ellipse(int largeur, int hauteur, Point point, Color backGroundColor, Color boderColor) {
        super(point, new Rectangle(largeur, hauteur), backGroundColor, boderColor);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }


    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(super.toString());
        sb.append(", largeur=").append(largeur);
        sb.append(", hauteur=").append(hauteur);
        return sb.toString();
    }
}
