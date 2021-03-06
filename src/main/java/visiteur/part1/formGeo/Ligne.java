package visiteur.part1.formGeo;

import visiteur.part1.visiteur.IFigureVisitor;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class Ligne extends AFormeGéométrique {
    private Point otherPoint;

    public Ligne(Point point, Point otherPoint, Color backGroundColor) {
        super(point, new Rectangle((int) point.getX(), (int) point.getY(), (int) point.getX() - (int) otherPoint.getX(), (int) point.getY() - (int) otherPoint.getY()), backGroundColor, backGroundColor);
        this.otherPoint = otherPoint;
    }

    public Point getOtherPoint() {
        return otherPoint;
    }


    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(super.toString());
        sb.append(", otherPoint = {x = ").append(otherPoint.getX())
                .append(" , y = ").append(otherPoint.getY()).append("}");
        return sb.toString();
    }
}
