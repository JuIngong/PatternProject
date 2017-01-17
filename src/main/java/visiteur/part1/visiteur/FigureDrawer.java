package visiteur.part1.visiteur;

import visiteur.part1.formGeo.*;
import visiteur.part1.formGeo.Composite;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by frederic on 10/01/2017.
 */
public class FigureDrawer implements IFigureVisitor {

    Graphics g;

    public FigureDrawer(Graphics g) {
        this.g = g;
    }

    public void visit(Composite c) {
        for (AFormeGéométrique child : c)
            child.accept(this);
    }

    public void visit(Cercle c) {
        c.generateBoundingBoc(new Rectangle(c.getPoint().x, c.getPoint().y, c.getRayon(), c.getRayon()));
        g.setColor(c.getBackGroundColor());
        g.fillOval(c.getPoint().x, c.getPoint().y, c.getRayon(), c.getRayon());
        g.setColor(c.getBboderColor());
        g.drawOval(c.getPoint().x, c.getPoint().y, c.getRayon(), c.getRayon());

    }

    public void visit(MyRectangle r) {
        r.generateBoundingBoc(new Rectangle(r.getPoint().x, r.getPoint().y, r.getLongeur(), r.getLargeur()));
        g.setColor(r.getBackGroundColor());
        g.fillRect(r.getPoint().x, r.getPoint().y, r.getLongeur(), r.getLargeur());
        g.setColor(r.getBboderColor());
        g.drawRect(r.getPoint().x, r.getPoint().y, r.getLongeur(), r.getLargeur());

    }

    public void visit(Carre s) {
        s.generateBoundingBoc(new Rectangle(s.getPoint().x, s.getPoint().y, s.getCote(), s.getCote()));
        //g.drawRect(s.getPoint().x, s.getPoint().y, s.getCote(), s.getCote());
        this.visit((MyRectangle) s);
    }

    public void visit(Ellipse e) {
        e.generateBoundingBoc(new Rectangle(e.getPoint().x, e.getPoint().y, e.getHauteur(), e.getLargeur()));
        g.setColor(e.getBackGroundColor());
        g.fillOval(e.getPoint().x, e.getPoint().y, e.getHauteur(), e.getLargeur());
        g.setColor(e.getBboderColor());
        g.drawOval(e.getPoint().x, e.getPoint().y, e.getHauteur(), e.getLargeur());
    }

    public void visit(Ligne l) {
        g.setColor(l.getBboderColor());
        g.drawLine(l.getPoint().x, l.getPoint().y, l.getOtherPoint().x, l.getOtherPoint().y);
    }

    public void visit(Texte t) {
        Rectangle2D rec = g.getFontMetrics().getStringBounds(t.getTexte(), g);
        t.generateBoundingBoc(new Rectangle(t.getPoint().x, t.getPoint().y, (int) rec.getWidth(), (int) rec.getHeight()));
        g.setColor(t.getBackGroundColor());
        g.fillRect((int) t.getPoint().getX(), (int) (t.getPoint().getY()-rec.getHeight()+4), (int) rec.getWidth(), (int) rec.getHeight());
        g.setColor(t.getBboderColor());
        g.drawString(t.getTexte(), t.getPoint().x, t.getPoint().y);
    }
}
