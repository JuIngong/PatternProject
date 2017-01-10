package Visiteur;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public  abstract class AFormeGéométrique {

    private Point point;
    private Rectangle boundingBox;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
