package usines.bebetes.usine;

/**
 * Created by Admin on 18/01/2017.
 */
public class EcoSystemeFactory {

    public static BebeteFactory getFactory(String type){
        if(type.equals("aleatoire"))
            return new Aleatoire();
        if(type.equals("mixte"))
            return new Mixte();
        return new Nuee();
    }
}
