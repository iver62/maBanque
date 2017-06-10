package org.sid.metier;

import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {
	
	public Compte consulterCompte(String idCompte);
	public void verser(String idCompte, double montant);
	public void retirer(String idCompte, double montant);
	public void virer(String idCompte1, String idCompte2, double montant);
	public Page<Operation> listOperations(String idCompte, int page, int size);

}
