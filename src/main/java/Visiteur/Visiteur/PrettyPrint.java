package Visiteur.Visiteur;

import Visiteur.FormGeo.*;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class PrettyPrint implements IFigureVisitor {
    String tab = "";

    public void visit(Composite c) {
        String oldTab = tab;
        System.out.println("Composite :");
        tab += "\t";
        for (AFormeGéométrique child : c)
            child.accept(this);
        tab = oldTab;
    }

    public void visit(Cercle c) {
        System.out.println(tab + "Circle:" + c);
    }

    public void visit(Carre s) {
        System.out.println(tab + "Square:" + s);
    }

    public void visit(MyRectangle r) {
        System.out.println(tab + "Rectangle:" + r);
    }

    public void visit(Texte t) {
        System.out.println(tab + "Texte:" + t);
    }

    public void visit(Ellipse e) {
        System.out.println(tab + "Ellipse:" + e);
    }

    public void visit(Ligne l) {
        System.out.println(tab + "Ligne:" + l);
    }
}

