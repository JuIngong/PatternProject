package Visiteur;

import java.awt.*;

/**
 * Created by frederic on 10/01/2017.
 */
public class Cercle extends AFormeGéométrique {

    private int rayon;

    public Cercle(Point point, int rayon){
        super(point, new Rectangle(rayon, rayon));
        this.rayon = rayon;
    }

    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
