package visiteur.part1.formGeo;

import visiteur.part1.AlignHorizon;
import visiteur.part1.AlignVerti;
import visiteur.part1.visiteur.IFigureVisitor;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public abstract class AFormeGéométrique {

    private Point point;
    private Rectangle boundingBox;
    private Color backGroundColor;
    private Color boderColor;
    private AlignVerti alignVerti = AlignVerti.HAUT;
    private AlignHorizon alignHorizon = AlignHorizon.GAUCHE;

    public AFormeGéométrique(Point point, Rectangle boundingBox, Color backGroundColor, Color boderColor) {
        this.point = point;
        this.boundingBox = boundingBox;
        this.backGroundColor = backGroundColor;
        this.boderColor = boderColor;
    }

    public AFormeGéométrique(Point point, Color backGroundColor, Color boderColor) {
        this.point = point;
        this.backGroundColor = backGroundColor;
        this.boderColor = boderColor;
    }

    public void generateBoundingBoc(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public abstract void accept(IFigureVisitor figureVisitor);

    public void changeAlignements(AlignHorizon alignHorizon, AlignVerti alignVerti) {
        this.alignHorizon = alignHorizon;
        this.alignVerti = alignVerti;
        int x = alignHorizon.adapt((int) point.getX(), (int) boundingBox.getWidth());
        int y = alignVerti.adapt((int) point.getY(), (int) boundingBox.getHeight());
        this.point = new Point(x, y);
    }

    public Color getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(Color backGroundColor) {
        this.backGroundColor = backGroundColor;
    }

    public Color getBboderColor() {
        return boderColor;
    }

    public void setBoderColor(Color boderColor) {
        this.boderColor = boderColor;
    }

    public AlignVerti getAlignVerti() {
        return alignVerti;
    }

    public void setAlignVerti(AlignVerti alignVerti) {
        this.alignVerti = alignVerti;
    }

    public AlignHorizon getAlignHorizon() {
        return alignHorizon;
    }

    public void setAlignHorizon(AlignHorizon alignHorizon) {
        this.alignHorizon = alignHorizon;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append("point= {x = ").append(point.getX())
                .append(" , y = ").append(point.getY()).append("}");
        return sb.toString();
    }
}
