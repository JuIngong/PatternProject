package usines.bebetes.usine;

import usines.bebetes.Bebete;
import usines.bebetes.BebeteHasard;
import usines.visu.Champ;

import java.awt.*;

/**
 * Created by Admin on 18/01/2017.
 */
public class Aleatoire implements BebeteFactory{

    @Override
    public Bebete getBebete(Champ c, int x, int y, double dC, double vC, Color col, int i) {
        return new BebeteHasard(c, x, y, dC, vC, col);
    }
}
