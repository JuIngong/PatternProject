package visiteur.part2.avecVisiteur.bebetes;

import visiteur.part1.visiteur.IFigureVisitor;
import visiteur.part2.avecVisiteur.simu.Actionnable;
import visiteur.part2.avecVisiteur.visiteur.IBebeteVisitor;
import visiteur.part2.avecVisiteur.visiteur.IPositionnableVisitor;
import visiteur.part2.avecVisiteur.visu.Champ;
import visiteur.part2.avecVisiteur.visu.Dessinable;
import visiteur.part2.avecVisiteur.visu.PerceptionAble;

import java.awt.*;

public abstract class Bebete extends PerceptionAble implements Actionnable, Dessinable {

	protected double champDeVue = (Math.PI / 4); // En radians
	protected int longueurDeVue = 20; // nb de pixel pour la longueur du champ de vision

	protected double x, y;                 // position � l'�cran
	protected double vitesseCourante;      // vitesse en pixels par second (float pour conserver la pr�cision du calcul de vitesse)
	protected double directionCourante;  // en radians [0 - 2 PI[
	protected Color couleur;            // Couleur de remplissage


	protected double prochaineVitesse;      // vitesse en pixels par second (float pour conserver la pr�cision du calcul de vitesse)
	protected double prochaineDirection;  // en radians [0 - 2 PI[
	protected Champ champ;     // Le champ

	public  void accept(IBebeteVisitor bebeteVisitor){
		bebeteVisitor.visit(this);
	}

	@Override
	public void accept(IPositionnableVisitor positionnableVisitor) {
		positionnableVisitor.visit(this);
	}

/* Impl�mentation de Positionnable */

	@Override
	public double getX() {
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public Champ getChamp() {
		return champ;
	}

	/* Impl�mentation de Dirigeable */

	@Override
	public double getVitesseCourante() {
		return vitesseCourante;
	}

	@Override
	public void setVitesseCourante(double vitesseCourante) {
		this.vitesseCourante = vitesseCourante;
		this.prochaineVitesse = vitesseCourante;
	}

	@Override
	public double getDirectionCourante() {
		return directionCourante;
	}

	@Override
	public void setDirectionCourante(double directionCourante) {
		this.directionCourante = directionCourante;
		this.prochaineDirection = directionCourante;

	}


	/* Impl�mentation de Dessinable */

	@Override
	public Color getCouleur() {
		return couleur;
	}

	/* Impl�mentation de Actionnable */

	@Override
	public abstract void calculeDeplacementAFaire()  ;

	@Override
	public abstract void effectueDeplacement() ;


	/* Impl�mentation de PerceptionAble */

	@Override
	public  double getChampDeVue() {
		// TODO Auto-generated method stub
		return champDeVue;
	}

	@Override
	public  int getLongueurDeVue() {
		// TODO Auto-generated method stub
		return longueurDeVue;
	}

	
	public  void setLongueurDeVue(int lDV) { 
		longueurDeVue = lDV;
	}

	public  void setChampDeVue(double cDV) { 
		champDeVue = cDV;
	}


}
