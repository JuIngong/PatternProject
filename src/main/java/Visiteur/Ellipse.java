package Visiteur;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class Ellipse extends AFormeGéométrique {
    private int largeur;
    private int longueur;

    public Ellipse(int largeur, int hauteur, Point point) {
        super(point, new Rectangle(largeur, hauteur));
        this.largeur = largeur;
        this.longueur = longueur;
    }
}
