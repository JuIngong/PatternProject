package usines.bebetes.usine;

import usines.bebetes.Bebete;
import usines.bebetes.BebeteEmergente;
import usines.bebetes.BebeteHasard;
import usines.visu.Champ;

import java.awt.*;

/**
 * Created by Admin on 18/01/2017.
 */
public class Mixte implements BebeteFactory{

    @Override
    public Bebete getBebete(Champ c, int x, int y, double dC, double vC, Color col, int i) {
        if(i%2 == 1)
            return new BebeteEmergente(c, x, y, dC, vC, col);
        else
            return new BebeteHasard(c, x, y, dC, vC, col);
    }
}
