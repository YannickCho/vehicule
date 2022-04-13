package org.eclipse.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="VOITURE")
public class Voiture extends Vehicule {
	private int nbPortes;
	
	public Voiture() {
		super();
	}

	public int getNbPortes() {
		return nbPortes;
	}

	public void setNbPortes(int nbportes) {
		this.nbPortes = nbportes;
	}

	
}
