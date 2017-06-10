package org.sid.metier;

import java.util.Date;

import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Compte;
import org.sid.entities.CompteCourant;
import org.sid.entities.Operation;
import org.sid.entities.Retrait;
import org.sid.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(String idCompte) {
		Compte cp = compteRepository.findOne(idCompte);
		if (cp == null) {
			throw new RuntimeException("Compte introuvable");
		}
		return cp;
	}

	@Override
	public void verser(String idCompte, double montant) {
		Compte cp = consulterCompte(idCompte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String idCompte, double montant) {
		Compte cp = consulterCompte(idCompte);
		double facilitesCaisse = 0;
		if (cp instanceof CompteCourant) {
			facilitesCaisse = ((CompteCourant) cp).getDecouvert();
		}
		if (cp.getSolde() + facilitesCaisse < montant) {
			throw new RuntimeException("Solde insuffisant");
		}
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);
	}

	@Override
	public void virer(String idCompte1, String idCompte2, double montant) {
		if (idCompte1.equals(idCompte2)) {
			throw new RuntimeException("Impossible d'effectuer un virement sur le même compte");
		}
		retirer(idCompte1, montant);
		verser(idCompte2, montant);
	}

	@Override
	public Page<Operation> listOperations(String idCompte, int page, int size) {
		return operationRepository.listOperations(idCompte, new PageRequest(page, size));
	}

}
