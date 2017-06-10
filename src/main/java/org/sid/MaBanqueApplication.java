package org.sid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaBanqueApplication implements CommandLineRunner {
	
//	@Autowired
//	private ClientRepository clientRepository;
//	@Autowired
//	private CompteRepository compteRepository;
//	@Autowired
//	private OperationRepository operationRepository;
//	@Autowired
//	private IBanqueMetier banqueMetier;

	public static void main(String[] args) {
		SpringApplication.run(MaBanqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*
		Client c1 = clientRepository.save(new Client("Hassan", "hassan@gmail.com"));
		Client c2 = clientRepository.save(new Client("Rachid", "rachid@gmail.com"));
		
		Compte cp1 = compteRepository.save(new CompteCourant("c1", new Date(), 90000, c1, 6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("c2", new Date(), 90000, c2, 5.5));
		
		operationRepository.save(new Versement(new Date(), 9000, cp1));
		operationRepository.save(new Versement(new Date(), 6000, cp1));
		operationRepository.save(new Versement(new Date(), 2300, cp1));
		operationRepository.save(new Retrait(new Date(), 9000, cp1));
		
		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Versement(new Date(), 400, cp2));
		operationRepository.save(new Versement(new Date(), 2300, cp2));
		operationRepository.save(new Retrait(new Date(), 3000, cp2));
		
		banqueMetier.verser("c1", 111111);
		*/
	}
}
