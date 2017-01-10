package Visiteur;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class Ellipse extends AFormeGéométrique {
    private int largeur;
    private int hauteur;

    public Ellipse(int largeur, int hauteur, Point point) {
        super(point, new Rectangle(largeur, hauteur));
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
}
