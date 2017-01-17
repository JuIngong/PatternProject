package visiteur.part2.sansVisiteur.bebetes;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

import visiteur.part2.sansVisiteur.simu.Actionnable;
import visiteur.part2.sansVisiteur.simu.Simulateur;
import visiteur.part2.sansVisiteur.visu.Dessinable;
import visiteur.part2.sansVisiteur.visu.Positionnable;
import visiteur.part2.sansVisiteur.visu.VisualisateurAnime;


public class ChampDeBebetes extends VisualisateurAnime implements Observer {
    private static final long serialVersionUID = 5823608240299297297L;

    public static final double vitesseMax = 10f;

    protected Simulateur simu; // Mariage de convenance !!!

    public ChampDeBebetes(int largeur, int hauteur, int nb) {
        super(largeur, hauteur);
        setPreferredSize(new Dimension(largeur, hauteur));
        List<? extends Bebete> lb = fabriqueBebetes(nb);
        // Initialisation du mariage de convenance avec le simulateur
        simu = new Simulateur(50, lb);
        simu.addObserver(this);
        setDessinables(lb);
    }

	/* Red�finitions pour synchroniser la gestion des 2 threads */

    public void demarre() {
        // on d�marre d'abord la simulation
        simu.demarre();
        super.demarre();
    }

    public void arrete() {
        // on arr�te d'abord la visualisation
        super.arrete();
        simu.arrete();
    }

    public ArrayList<? extends Bebete> fabriqueBebetes(int nb) {
        ArrayList<BebeteEmergente> nouvBebetes = new ArrayList<BebeteEmergente>();
        Random generateur = new Random();
        // unicit� des couleurs des b�b�tes, juste l� pour faire joli...
        double racineCubiqueDuNombreDeBebetes = Math.pow((double) nb, 1.0 / 3.0);
        double etapeDeCouleur = (1.0 / racineCubiqueDuNombreDeBebetes);
        float r = 0.0f;
        float g = 0.0f;
        float b = 0.0f;
        for (int i = 0; i < nb; i++) {
            int x = (int) (generateur.nextFloat() * largeur);
            if (x > largeur - Bebete.TAILLEGRAPHIQUE)
                x -= Bebete.TAILLEGRAPHIQUE;
            int y = (int) (generateur.nextFloat() * hauteur);
            if (y > hauteur - Bebete.TAILLEGRAPHIQUE)
                y -= Bebete.TAILLEGRAPHIQUE;
            double direction = (generateur.nextFloat() * 2 * Math.PI);
            double vitesse = Math.max(2, generateur.nextDouble() * vitesseMax);
            r += etapeDeCouleur;
            if (r > 1.0) {
                r -= 1.0f;
                g += etapeDeCouleur;
                if (g > 1.0) {
                    g -= 1.0f;
                    b += etapeDeCouleur;
                    if (b > 1.0)
                        b -= 1.0f;
                }
            }
            // Le fameux de la capture impossible du joker ?
            nouvBebetes.add(new BebeteEmergente(this, x, y, direction, vitesse,
                    new Color(r, g, b)));
        }
        return nouvBebetes;
    }

    public int getNombreDeBebetes() {
        return getPositionnables().size();
    }

    public int getDelaiSimulation() { // D�l�gation
        return simu.getDelaiSimulation();
    }

    public void setDelaiSimulation(int delaiSimu) { // D�l�gation
        simu.setDelaiSimulation(delaiSimu);
    }

    public void nextStep() {
        simu.iteration();
    }

    @Override
    public void setDessinables(List<? extends Dessinable> dessinables) {
        super.setDessinables(dessinables);

        // a cause des deux mariages : une liste pour deux...
        // a condition qu'elles soient compatibles...
        ArrayList<Actionnable> output = new ArrayList<Actionnable>();

        if (dessinables != null) {
            for (Positionnable p : dessinables) {
                if (p instanceof Actionnable)
                    output.add((Actionnable) p);
            }
            simu.setActionnables(output);
        }


    }

    @Override
    public void update(Observable o, Object arg) {
        // Visualisateur va s'occuper d'afficher les champs
        total = simu.getActionnables().size();
        nombreBebetes.put("BebeteEmergente", 0);
        nombreBebetes.put("BebeteHasard", 0);
        int totalX = 0, totalY = 0, totalVitesse = 0;
        for (Actionnable a : simu.getActionnables()) {
            if (nombreBebetes.containsKey(a.getClass().getSimpleName())) {
                nombreBebetes.put(a.getClass().getSimpleName(), nombreBebetes.get(a.getClass().getSimpleName()) + 1);
            }
            Bebete bebeteCourante = (Bebete) a;
            totalVitesse += bebeteCourante.getVitesseCourante();
            totalX += bebeteCourante.getX();
            totalY += bebeteCourante.getY();
        }
        posMoyenne = new Point(totalX / total, totalY / total);
        vitesseMoyenne = (double) totalVitesse / total;

        // pour l'ecriture dans un fichier

        File file = new File("log.txt");

        try {
            /*
             * On utilise donc un PrintWriter (pour les méthodes de haut niveau) par dessus un BufferedWriter
			 * (pour l'écriture rapide) sur un FileWriter (pour l'écriture vers un fichier texte).
			 */
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            pw.println("Total : " + total);
            pw.println("Total bebetes emergentes : " + nombreBebetes.get("BebeteEmergente"));
            pw.println("Total bebetes hasard : " + nombreBebetes.get("BebeteHasard"));
            pw.println("Vitesse moyenne : " + vitesseMoyenne);
            pw.println("Position moyenne : [x : " + (int) posMoyenne.getX() + " , y : " + (int) posMoyenne.getY() + "]");

            pw.close();
        } catch (IOException exception) {
            System.out.println("Erreur lors de l'ecriture : " + exception.getMessage());
        }
    }
}
