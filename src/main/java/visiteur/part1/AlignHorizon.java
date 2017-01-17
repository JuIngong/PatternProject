package visiteur.part1;

/**
 * Created by JuIngong on 17/01/2017.
 */
public enum AlignHorizon {
    GAUCHE, CENTRE, DROITE;

    public int adapt(int x, int largeur) {
        switch(this) {
            case GAUCHE: return x;
            case CENTRE: return x - (largeur>>1);
            case DROITE: return x - largeur;
        }
        return x;
    }
}
