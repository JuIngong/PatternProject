package Visiteur;

import java.applet.Applet;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by frederic on 10/01/2017.
 */
public class AppGraphique extends Applet {

    public void paint(Graphics g){
        FigureDrawer drawer = new FigureDrawer(g);
        List<AFormeGéométrique> formes = new ArrayList();
        Cercle c = new Cercle(new Point(50,30), 20);
        MyRectangle r = new MyRectangle(new Point(50,50), 20,20);
        Ligne l = new Ligne(new Point(70,70), new Point(90,30));

        formes.add(c);
        formes.add(r);
        formes.add(l);
        
        for(AFormeGéométrique f : formes){
            f.accept(drawer);
        }
    }
}
