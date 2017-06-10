package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idClient;
	private String nomClient;
	private String email;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	public Client() {
		super();
	}

	public Client(String nomClient, String email) {
		super();
		this.nomClient = nomClient;
		this.email = email;
	}

	public Long getIdClient() {
		return idClient;
	}
	
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	
	public String getNomClient() {
		return nomClient;
	}
	
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}
	
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	

}
