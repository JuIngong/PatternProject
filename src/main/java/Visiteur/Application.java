package Visiteur;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class created on 10/01/2017
 *
 * @author JuIngong
 */
public class Application {
    public static void main(String[] args) {
        IFigureVisitor figureVisitor = new PrettyPrint();
        List<AFormeGéométrique> list = new ArrayList<>();
        list.add(new Carre(new Point(0, 0), 25));
        list.add(new MyRectangle(new Point(43, 54), 12, 34));
        list.add(new Cercle(new Point(54, 65), 23));
        list.add(new Ellipse(34, 43, new Point(76, 765)));
        list.add(new Ligne(new Point(54, 65), new Point(43, 80)));
        list.add(new Texte(new Point(54, 65), "Test"));
        for (AFormeGéométrique g : list ) {
            g.accept(figureVisitor);
        }
    }
}