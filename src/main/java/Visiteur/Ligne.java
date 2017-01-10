package Visiteur;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class Ligne extends AFormeGéométrique {
    private Point otherPoint;

    public Ligne(Point point, Point otherPoint) {
        super(point, new Rectangle((int) point.getX(), (int) point.getY(), (int) point.getX() - (int) otherPoint.getX(), (int) point.getY() - (int) otherPoint.getY()));
        this.otherPoint = otherPoint;
    }

    public Point getOtherPoint() {
        return otherPoint;
    }


    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
