package Visiteur;

import java.awt.*;

/**
 * Created by frederic on 10/01/2017.
 */
public class MyRectangle extends AFormeGéométrique {

    private int longeur;
    private int largeur;

    public MyRectangle(Point point, int longeur, int largeur){
        super(point, new Rectangle(longeur, largeur));
        this.longeur = longeur;
        this.largeur = largeur;
    }

    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
