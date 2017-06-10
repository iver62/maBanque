package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	
	private static final long serialVersionUID = 1L;
	private double taux;

	public CompteEpargne() {
		super();
	}
	
	public CompteEpargne(String idCompte, Date dateCreation, double solde, Client client, double taux) {
		super(idCompte, dateCreation, solde, client);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
