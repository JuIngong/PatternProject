package Visiteur;

import java.awt.*;

/**
 * Created by frederic on 10/01/2017.
 */
public class FigureDrawer implements IFigureVisitor {

    Graphics g;
    FigureDrawer(Graphics g) { this.g = g; }

    public void visit(Composite c) {
        //TODO : comment ça marche ?
    }

    public void visit(Cercle c) {
        g.drawOval(c.getPoint().x, c.getPoint().y, c.getRayon(), c.getRayon());
    }

    public void visit(MyRectangle r) {
        g.drawRect(r.getPoint().x, r.getPoint().y, r.getLongeur(), r.getLargeur());
    }

    public void visit(Carre s) {
        g.drawRect(s.getPoint().x, s.getPoint().y, s.getCote(), s.getCote());
    }

    public void visit(Ellipse e) {
        g.drawOval(e.getPoint().x, e.getPoint().y, e.getHauteur(), e.getLargeur());
    }

    public void visit(Ligne l) {
        g.drawLine(l.getPoint().x, l.getPoint().y, l.getOtherPoint().x, l.getOtherPoint().y);
    }

    public void visit(Texte t) {
        g.drawString(t.getTexte(), t.getPoint().x, t.getPoint().y);
    }
}
