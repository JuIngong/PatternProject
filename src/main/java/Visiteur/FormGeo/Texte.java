package Visiteur.FormGeo;

import Visiteur.Visiteur.IFigureVisitor;

import java.awt.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class Texte extends AFormeGéométrique {
    public String getTexte() {
        return texte;
    }

    private String texte;

    public Texte(Point point, String texte, Color backGroundColor, Color boderColor) {
        super(point, backGroundColor, boderColor);
        this.texte = texte;
    }

    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(super.toString());
        sb.append(", texte='").append(texte).append('\'');
        return sb.toString();
    }
}
