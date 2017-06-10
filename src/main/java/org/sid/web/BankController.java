package org.sid.web;

import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BankController {
	
	@Autowired
	private IBanqueMetier banqueMetier;
	
	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
	
	@RequestMapping("/consulterCompte")
	public String consulter(Model model, String idCompte, @RequestParam(name="page", defaultValue="0")int page, @RequestParam(name="size", defaultValue="5")int size) {
		model.addAttribute("idCompte", idCompte);
		try {
			Compte cp = banqueMetier.consulterCompte(idCompte);
			Page<Operation> pageOperations = banqueMetier.listOperations(idCompte, page, size);
			model.addAttribute("listOperations", pageOperations.getContent());
			int[] pages = new int[pageOperations.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("compte", cp);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "comptes"; // retourne à la vue comptes.html
	}
	
	@RequestMapping(value="/saveOperation", method=RequestMethod.POST)
	public String saveOperation(Model model, String typeOperation, String idCompte, double montant, String idCompteDest) {
		try {
			if (typeOperation.equals("versement")) {
				banqueMetier.verser(idCompte, montant);
			}
			else if (typeOperation.equals("retrait")) {
				banqueMetier.retirer(idCompte, montant);
			}
			else {
				banqueMetier.virer(idCompte, idCompteDest, montant);
			}
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consulterCompte?idCompte=" + idCompte + "&error=" + e.getMessage();
		}
		return "redirect:/consulterCompte?idCompte=" + idCompte;
	}

}
