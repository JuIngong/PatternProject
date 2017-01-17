package visiteur.part1;

import visiteur.part1.formGeo.Composite;
import visiteur.part1.visiteur.FigureDrawer;

import visiteur.part1.formGeo.*;

import java.applet.Applet;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by frederic on 10/01/2017.
 */
public class AppGraphique extends Applet {

    public void paint(Graphics g) {
        FigureDrawer drawer = new FigureDrawer(g);
        List<AFormeGéométrique> formes = new ArrayList();

        Cercle c = new Cercle(new Point(50, 30), 20, Color.PINK, Color.BLACK);
        Carre r = new Carre(new Point(50, 50), 20, Color.PINK, Color.BLACK);
        Ligne l = new Ligne(new Point(70, 70), new Point(90, 30), Color.BLACK);
        Texte t = new Texte(new Point(100, 100), "TP visiteur Patron", Color.LIGHT_GRAY, Color.RED);
        MyRectangle s = new MyRectangle(new Point(100, 105), 95, 2, Color.LIGHT_GRAY, Color.RED);

        AFormeGéométrique[] forCompo = {new Cercle(new Point(55, 36), 3, Color.BLUE, Color.BLACK), new Cercle(new Point(62, 36), 3, Color.BLUE, Color.BLACK)};
        Composite co = new Composite(new Point(0, 0), forCompo, Color.CYAN, Color.BLACK);

        formes.add(c);
        formes.add(r);
        formes.add(l);
        formes.add(t);
        formes.add(s);
        formes.add(co);

        for (AFormeGéométrique f : formes) {
            f.accept(drawer);
        }
    }
}
