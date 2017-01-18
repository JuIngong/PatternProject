package usines.bebetes.usine;

import usines.bebetes.Bebete;
import usines.bebetes.BebeteEmergente;
import usines.visu.Champ;

import java.awt.*;
import java.util.List;

/**
 * Created by Admin on 18/01/2017.
 */
public class Nuee implements BebeteFactory {

    @Override
    public Bebete getBebete(Champ c, int x, int y, double dC, double vC, Color col, int i) {
        return new BebeteEmergente(c, x, y, dC, vC, col);
    }
}
