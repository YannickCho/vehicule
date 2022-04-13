package org.eclipse.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="CAMION")
public class Camion extends Vehicule {
	private int volume;
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="camion")
	private List<Colis> colis = new ArrayList<Colis>();
	
	public Camion() {
		super();
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public List<Colis> getColis() {
		return colis;
	}

	public void setColis(List<Colis> colis) {
		this.colis = colis;
	}

	public void addColis(Colis e) {
		colis.add(e);
		e.setCamion(this);
	}

	public void removeColis(Colis e) {
		colis.remove(e);
	}

	
}
