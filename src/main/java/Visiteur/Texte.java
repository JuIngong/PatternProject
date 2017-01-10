package Visiteur;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class Texte extends AFormeGéométrique{
    public String getTexte() {
        return texte;
    }

    private String texte;

    public Texte(Point point, String texte) {
        super(point);
        this.texte = texte;
    }

    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
