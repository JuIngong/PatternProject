package Visiteur;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class Ligne extends AFormeGéométrique {
    private int epaisseur;
    private Point otherPoint;

    public Ligne(Point point, int epaisseur, Point otherPoint) {
        super(point, new Rectangle((int) point.getX(), (int) point.getY(), (int) point.getX() - (int) otherPoint.getX(), (int) point.getY() - (int) otherPoint.getY()));
        this.epaisseur = epaisseur;
        this.otherPoint = otherPoint;
    }

}
