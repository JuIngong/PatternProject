package visiteur.part2.avecVisiteur.visiteur;

import visiteur.part2.avecVisiteur.bebetes.Bebete;
import visiteur.part2.avecVisiteur.bebetes.BebeteEmergente;
import visiteur.part2.avecVisiteur.bebetes.BebeteHasard;

/**
 * Created by JuIngong on 17/01/2017.
 */
public interface IPositionnableVisitor {
    void visit(BebeteEmergente bebeteEmergente);
    void visit(BebeteHasard bebeteHasard);
    void visit(Bebete bebete);
}
