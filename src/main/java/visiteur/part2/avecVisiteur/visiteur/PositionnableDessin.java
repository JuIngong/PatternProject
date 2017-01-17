package visiteur.part2.avecVisiteur.visiteur;

import visiteur.part2.avecVisiteur.bebetes.Bebete;
import visiteur.part2.avecVisiteur.bebetes.BebeteEmergente;
import visiteur.part2.avecVisiteur.bebetes.BebeteHasard;

import java.awt.*;

/**
 * Created by JuIngong on 17/01/2017.
 */
public class PositionnableDessin implements IPositionnableVisitor {

    Graphics g;

    public PositionnableDessin(Graphics g) {
        this.g = g;
    }

    @Override
    public void visit(BebeteEmergente bebeteEmergente) {
        this.visit((Bebete) bebeteEmergente);
    }

    @Override
    public void visit(BebeteHasard bebeteHasard) {
        this.visit((Bebete) bebeteHasard);

    }

    @Override
    public void visit(Bebete bebete) {
        int x = (int) bebete.getX();
        int y = (int) bebete.getY();

        int CDVDegres = (int) Math.toDegrees(bebete.getChampDeVue());
        g.setColor(bebete.getCouleur());
        g.fillArc(x, y, bebete.TAILLEGRAPHIQUE, bebete.TAILLEGRAPHIQUE, -(int) Math
                .toDegrees(bebete.getDirectionCourante())
                - (CDVDegres / 2), CDVDegres);
    }
}
