package Visiteur;

/**
 * Created by frederic on 10/01/2017.
 */
public interface IFigure {

    void accept(IFigureVisitor visitor);
}
