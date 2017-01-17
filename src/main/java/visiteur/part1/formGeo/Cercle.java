package visiteur.part1.formGeo;

import visiteur.part1.visiteur.IFigureVisitor;

import java.awt.*;

/**
 * Created by frederic on 10/01/2017.
 */
public class Cercle extends AFormeGéométrique {

    private int rayon;

    public Cercle(Point point, int rayon, Color backGroundColor, Color boderColor){
        super(point, new Rectangle(rayon, rayon), backGroundColor, boderColor);
        this.rayon = rayon;
    }

    public int getRayon() {
        return rayon;
    }


    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(super.toString());
        sb.append(", rayon=").append(rayon);
        return sb.toString();
    }
}
