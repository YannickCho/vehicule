package org.eclipse.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_VEHICULE")
@DiscriminatorValue(value="VEHICULE")
public class Vehicule {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String immatriculation;
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="vehicule")
	private List<Personne> personnes = new ArrayList<Personne>();
	
	public Vehicule() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public void addPersonne(Personne e) {
		personnes.add(e);
		e.setVehicule(this);
	}

	public void remove(Personne e) {
		personnes.remove(e);
	}

	@Override
	public String toString() {
		return "id : " + id + "   immatriculation : " + immatriculation + "   personnes : " + personnes;
	}

	
}
