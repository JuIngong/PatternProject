package visiteur.part1;

/**
 * Created by JuIngong on 17/01/2017.
 */
public enum AlignVerti {
    HAUT, MILIEU, BAS;

    public int adapt(int y, int hauteur) {
        switch(this) {
            case HAUT: return y;
            case MILIEU: return y - (hauteur>>1);
            case BAS: return y - hauteur;
        }
        return y;
    }
}
