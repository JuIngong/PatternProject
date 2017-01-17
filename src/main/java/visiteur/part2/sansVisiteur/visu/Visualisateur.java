/**
 * 
 */
package visiteur.part2.sansVisiteur.visu;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

/**
 * @author  collet
 */
public class Visualisateur extends JPanel implements Champ  {
	private static final long serialVersionUID = 5445641169751870919L;

	protected List<? extends Dessinable> dessinables;
	protected int largeur;
	protected int hauteur;
	protected HashMap<String, Integer> nombreBebetes;
	protected int total;
	protected Point posMoyenne;
	protected double vitesseMoyenne;

	public Visualisateur(int largeur, int hauteur, List<? extends Dessinable> ld) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		dessinables = ld;
		nombreBebetes = new HashMap<>();
		total = 0;
		posMoyenne = new Point();
		vitesseMoyenne = 0;
	}

	public Visualisateur(int largeur, int hauteur) {
		this(largeur,hauteur,new ArrayList<Dessinable>(0));
	}

	public Visualisateur() {
		this(640,480);
	}

	/* Impl�mentation de l'interface Champ */

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public List<? extends Positionnable> getPositionnables() {
		return dessinables;
	}

	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setStroke(new BasicStroke(3f));
		super.paint(g);
		for(Dessinable d : dessinables)
			d.seDessine(g);
		g.drawString("Total : " + total, 10, 10);
		g.drawString("Total bebetes emergentes : " + nombreBebetes.get("BebeteEmergente"), 10, 30);
		g.drawString("Total bebetes hasard : " + nombreBebetes.get("BebeteHasard"), 10, 50);
		g.drawString("Vitesse moyenne : " + vitesseMoyenne, 10, 70);
		g.drawString("Position moyenne : [x : " + (int)posMoyenne.getX() + " , y : "+(int)posMoyenne.getY()+"]", 10, 90);

	}

	public void setNombreBebetes(HashMap<String , Integer> nombreBebetes) {
		this.nombreBebetes = nombreBebetes;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setPosMoyenne(Point posMoyenne) {
		this.posMoyenne = posMoyenne;
	}

	public void setVitesseMoyenne(double vitesseMoyenne) {
		this.vitesseMoyenne = vitesseMoyenne;
	}

	public void setDessinables(List<? extends Dessinable> dessinables) {
		this.dessinables = dessinables;
	}

}
