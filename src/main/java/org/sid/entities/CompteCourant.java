package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	
	private static final long serialVersionUID = 1L;
	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(String idCompte, Date dateCreation, double solde, Client client, double decouvert) {
		super(idCompte, dateCreation, solde, client);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

}
