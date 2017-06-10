package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE", discriminatorType=DiscriminatorType.STRING, length=2)
public class Compte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String idCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	
	public Compte() {
		super();
	}

	public Compte(String idCompte, Date dateCreation, double solde, Client client) {
		super();
		this.idCompte = idCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}

	public String getIdCompte() {
		return idCompte;
	}
	
	public void setIdCompte(String idCompte) {
		this.idCompte = idCompte;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public double getSolde() {
		return solde;
	}
	
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Collection<Operation> getOperations() {
		return operations;
	}
	
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	

}
