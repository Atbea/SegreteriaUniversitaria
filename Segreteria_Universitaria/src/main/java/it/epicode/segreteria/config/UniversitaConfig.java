package it.epicode.segreteria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.segreteria.model.CorsoDiLaurea;
import it.epicode.segreteria.model.Studente;

/**
 * 
 * Questa classe permette la creazione dei vari bean
 * 
 * @author Simona Tedesco
 */

@Configuration
public class UniversitaConfig {
	
	@Bean("studente1")
	public Studente studente1 () {
		Studente studente1 = new Studente();
		studente1.setMatricola("3fjn5sj4sa34");
		studente1.setNome("Manuel");
		studente1.setCognome("Russo");
		studente1.setDataN("1987/04/23");
		studente1.setEmail("manuel.russo@gmail.com");
		studente1.setIndirizzoR("Via Verdi");
		studente1.setCittaR("Trento");
		studente1.setCorsoDiLaurea(psi());
		return studente1;
	}
	
	@Bean("studente2")
	public Studente studente2 () {
		Studente studente2 = new Studente();
		studente2.setMatricola("g5kdm8w0krn");
		studente2.setNome("Lorenza");
		studente2.setCognome("Amato");
		studente2.setDataN("1990/02/23");
		studente2.setEmail("lory.ama@gmail.com");
		studente2.setIndirizzoR("Via Arigni");
		studente2.setCittaR("Trieste");
		studente2.setCorsoDiLaurea(ec_a());
		return studente2;
	}
	
	@Bean("studente3")
	public Studente studente3 () {
		Studente studente3 = new Studente();
		studente3.setMatricola("ewj4053hsbr5");
		studente3.setNome("Matteo");
		studente3.setCognome("Lucci");
		studente3.setDataN("1989/11/30");
		studente3.setEmail("lucci.mat@gmail.com");
		studente3.setIndirizzoR("Via Condotti");
		studente3.setCittaR("Roma");
		studente3.setCorsoDiLaurea(giur());
		return studente3;
	}
	
	@Bean("1PSI")
	public CorsoDiLaurea psi () {
		CorsoDiLaurea psi = new CorsoDiLaurea();
		psi.setCodice("1PSI");
		psi.setNome("Psicologia");
		psi.setIndirizzo("Piscologia infantile");
		psi.setNumEsami(15);
		return psi;
	}
	
	@Bean("2EC_A")
	public CorsoDiLaurea ec_a () {
		CorsoDiLaurea ec_a = new CorsoDiLaurea();
		ec_a.setCodice("2EC_A");
		ec_a.setNome("Economia Aziendale");
		ec_a.setIndirizzo("Economia Del Turismo");
		ec_a.setNumEsami(17);
		return ec_a;
	}
	
	@Bean("3GIUR")
	public CorsoDiLaurea giur () {
		CorsoDiLaurea giur = new CorsoDiLaurea();
		giur.setCodice("3GIUR");
		giur.setNome("Giurisprudenza");
		giur.setIndirizzo("Diritto bancario - Giurisprudenza");
		giur.setNumEsami(23);
		return giur;
	}

}
