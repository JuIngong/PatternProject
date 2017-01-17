/**
 *
 */
package visiteur.part2.avecVisiteur.visu;

import visiteur.part2.avecVisiteur.visiteur.IPositionnableVisitor;

/**
 * @author collet
 */
public interface Positionnable {

    public double getX();

    public void setX(double x);

    public double getY();

    public void setY(double y);

    Champ getChamp();

    public void accept(IPositionnableVisitor positionnableVisitor);

}
