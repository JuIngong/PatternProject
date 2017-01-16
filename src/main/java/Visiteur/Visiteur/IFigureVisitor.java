package Visiteur.Visiteur;

import Visiteur.FormGeo.*;

/**
 * Created by frederic on 10/01/2017.
 */
public interface IFigureVisitor {

    void visit(Composite c);
    void visit(Cercle c);
    void visit(Carre s);
    void visit(MyRectangle r);
    void visit(Ellipse e);
    void visit(Ligne l);
    void visit(Texte t);
}