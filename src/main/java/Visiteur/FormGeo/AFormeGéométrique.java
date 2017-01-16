package Visiteur.FormGeo;

import Visiteur.Visiteur.IFigureVisitor;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public abstract class AFormeGéométrique {

    private Point point;
    private Rectangle boundingBox;

    public AFormeGéométrique(Point point, Rectangle boundingBox) {
        this.point = point;
        this.boundingBox = boundingBox;
    }

    public AFormeGéométrique(Point point) {
        this.point = point;
    }

    public void generateBoundingBoc(Rectangle boundingBox){
        this.boundingBox = boundingBox;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public abstract void accept(IFigureVisitor figureVisitor);

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append("point= {x = ").append(point.getX())
                .append(" , y = ").append(point.getY()).append("}");
        return sb.toString();
    }
}
