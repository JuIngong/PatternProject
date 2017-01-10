package Visiteur;

import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by frederic on 10/01/2017.
 */
public class Composite extends AFormeGéométrique implements Iterable<AFormeGéométrique>{

    private AFormeGéométrique[] children;

    @Override
    public Iterator<AFormeGéométrique> iterator() {
        return Arrays.asList(children).iterator();
    }

    @Override
    public void forEach(Consumer<? super AFormeGéométrique> action) {

    }

    @Override
    public Spliterator<AFormeGéométrique> spliterator() {
        return null;
    }

    public Composite(Point point, AFormeGéométrique[] children) {
        super(point);
        this.children = children;
    }

    @Override
    public void accept(IFigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
}
