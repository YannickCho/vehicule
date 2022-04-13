package org.eclipse.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Colis {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private int nature;

	@ManyToOne()
	@JoinColumn(name="camion", referencedColumnName="id", nullable=false)
	private Camion camion;
	
	public Colis() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNature() {
		return nature;
	}

	public void setNature(int nature) {
		this.nature = nature;
	}

	public Camion getCamion() {
		return camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}

	
	
}
