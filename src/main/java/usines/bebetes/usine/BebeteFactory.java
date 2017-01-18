package usines.bebetes.usine;

import usines.bebetes.Bebete;
import usines.visu.Champ;

import java.awt.*;

/**
 * Created by Admin on 18/01/2017.
 */
public interface BebeteFactory {

    Bebete getBebete(Champ c, int x, int y, double dC, double vC, Color col, int i);
}
