package visiteur.part1;

import visiteur.part1.formGeo.*;
import visiteur.part1.formGeo.Composite;
import visiteur.part1.visiteur.IFigureVisitor;
import visiteur.part1.visiteur.PrettyPrint;

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
        Carre c = new Carre(new Point(0, 0), 25, Color.BLACK, Color.blue);
        c.changeAlignements(AlignHorizon.DROITE, AlignVerti.BAS);
        list.add(c);
        list.add(new MyRectangle(new Point(43, 54), 12, 34, Color.BLACK, Color.blue));
        list.add(new Cercle(new Point(54, 65), 23, Color.BLACK, Color.blue));
        list.add(new Ellipse(34, 43, new Point(76, 765), Color.BLACK, Color.blue));
        list.add(new Ligne(new Point(54, 65), new Point(43, 80), Color.BLACK));
        list.add(new Texte(new Point(54, 65), "Test", Color.BLACK, Color.blue));
        for (AFormeGéométrique g : list ) {
            g.accept(figureVisitor);
        }
        AFormeGéométrique[] test = {new Carre(new Point(98, 15), 50, Color.BLACK, Color.blue),
        new MyRectangle(new Point(54, 98), 79, 47, Color.BLACK, Color.blue),
        new Cercle(new Point(654, 878), 20, Color.BLACK, Color.blue)};
        new Composite(new Point(65,874), test, Color.BLACK, Color.blue).accept(figureVisitor);
    }
}
