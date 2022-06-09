package it.epicode.segreteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.segreteria.model.CorsoDiLaurea;
import it.epicode.segreteria.model.Studente;
import it.epicode.segreteria.repository.CorsoDiLaureaRepository;
import it.epicode.segreteria.repository.StudenteRepository;
import it.epicode.segreteria.service.CorsoDiLaureaService;
import it.epicode.segreteria.service.StudenteService;
import lombok.extern.slf4j.Slf4j;


/**
 * 
 * Questa classe gestisce tutti i metodi get e post 
 * 
 * @author Simona Tedesco
 */

@Slf4j
@Controller
public class UniversitaController {

	@Autowired CorsoDiLaureaService cls;
	@Autowired CorsoDiLaureaRepository clr;
	@Autowired StudenteService ss;
	@Autowired StudenteRepository sr;
	
	
	
	/**
	 * 
	 * Questo metodo permette di visualizzare una home page
	 * utilizza un metodo GET
	 * @param codice
	 * @return una pagina html con 2 link
	 */
	@GetMapping("/home-page")
	public ModelAndView home () {
		ModelAndView mv = new ModelAndView("home-page");
		mv.addObject("titoloPagina", "Portale Studenti");
		log.info("------------home page");
		return mv;
	}
	
	/////////////////////////////////////////corsi di laurea
	
	
	
	/**
	 * 
	 * Questo metodo permette di visualizzare la lista di tutti i corsi di laurea presenti nel db
	 * Utilizza un metodo GET
	 * @return una pagina html con una lista
	 */
	@GetMapping("/elenco-corsi")
	public ModelAndView getCorsi () {
		ModelAndView mav = new ModelAndView("elenco-corsi");
		mav.addObject("allCorsi", cls.getCorsi());
		log.info("------------elenco corsi");
		return mav;
	}
	
	
	/**
	 * 
	 * Questi 2 metodi permettono di inserire un nuovo corso di laurea nel db
	 * Utilizza un metodo GET e un metodo POST
	 * @return un nuovo oggetto di tipo corso di laurea
	 */
	@GetMapping("/inserisciCorsoForm")
	public ModelAndView inserisciCorsoForm() {
		ModelAndView mav = new ModelAndView("inserisciCorsoForm");
		CorsoDiLaurea corso = new CorsoDiLaurea();
		mav.addObject("corso", corso);
		log.info("------------inserisci corso");
		return mav;
	}
	
	@PostMapping("/salvaCorso")
	public String salvaCorso(@ModelAttribute CorsoDiLaurea corso) {
		cls.inserisciCorso(corso);
		log.info("------------corso inserito");
		return "redirect:/elenco-corsi";
	}
	
	/**
	 * Questi 2 metodi permettono di modificare alcuni attributi dell'oggetto richiamato tramite la sua PK
	 * Utilizzano un metodo GET e un metodo POST
	 * @param codice
	 * @return l'oggetto corso di laurea modificato
	 */
	@GetMapping("/modifica-corso-form/{codice}")
	public ModelAndView modificaCorso(@PathVariable(name = "codice") String codice) {
		ModelAndView mav = new ModelAndView("modifica-corso-form");
		CorsoDiLaurea corso = clr.findById(codice).get();
		mav.addObject("corso", corso);
		log.info("------------modifica corso");
		return mav;
	}
	
	@PostMapping("/salvaModifica")
	public String salvaModifica(@ModelAttribute CorsoDiLaurea corso) {
		cls.inserisciCorso(corso);
		log.info("------------corso modificato");
		return "redirect:/elenco-corsi";
	}
	
	
	/**
	 * Questo metodo permette di eliminare un oggetto corso di laurea dal db, richiamandolo tramite la sua PK
	 * Utilizza un metodo GET
	 * @param codice
	 * @return elimina un oggetto dal db
	 */
	
	@GetMapping("/elimina-corso/{codice}")
	public ModelAndView confermaEliminazione (@PathVariable(name = "codice") String codice) {
		ModelAndView mv = new ModelAndView("elimina-corso");
		mv.addObject("conferma", "Conferma Eliminazione");
		cls.eliminaCorso(codice);
		log.info("------------conferma eliminazione");
		return mv;
	}
	
	
	
	
	
	
	/////////////////////////// studenti
	
	
	/**
	 * 
	 * Questo metodo permette di visualizzare la lista di tutti gli studenti presenti nel db
	 * Utilizza un metodo GET
	 * @return una pagina html con una lista
	 */
	
	@GetMapping("/elenco-studenti")
	public ModelAndView getStudenti() {
		ModelAndView mav = new ModelAndView("elenco-studenti");
		mav.addObject("allStudenti", ss.getStudenti());
		log.info("---------------elenco studenti");
		return mav;
	}
	
	
	/**
	 * 
	 * Questi 2 metodi permettono di inserire un nuovo studente nel db
	 * Utilizza un metodo GET e un metodo POST
	 * @return un nuovo oggetto di tipo studente
	 */
	
	@GetMapping("/inserisciStudenteForm")
	public ModelAndView inserisciStudenteForm() {
		ModelAndView mav = new ModelAndView("inserisciStudenteForm");
		Studente studente = new Studente();
		mav.addObject("studente", studente);
		log.info("------------inserisci studente");
		return mav;
	}
	
	@PostMapping("/salvaStudente")
	public String salvaStudente(@ModelAttribute Studente studente) {
		ss.inserisciStudente(studente);
		log.info("------------studente inserito");
		return "redirect:/elenco-studenti";
	}
	
	
	/**
	 * Questi 2 metodi permettono di modificare alcuni attributi dell'oggetto richiamato tramite la sua PK
	 * Utilizzano un metodo GET e un metodo POST
	 * @param matricola
	 * @return l'oggetto studente modificato
	 */
	@GetMapping("/modifica-studente-form/{matricola}")
	public ModelAndView modificaStudente(@PathVariable(name = "matricola") String matricola) {
		ModelAndView mav = new ModelAndView("modifica-studente-form");
		Studente studente = sr.findById(matricola).get();
		mav.addObject("studente", studente);
		log.info("------------modifica studente");
		return mav;
	}
	
	@PostMapping("/salvaModificaS")
	public String salvaModificaS(@ModelAttribute Studente studente) {
		ss.inserisciStudente(studente);
		log.info("------------studente modificato");
		return "redirect:/elenco-studenti";
	}
	
	
	/**
	 * Questo metodo permette di eliminare un oggetto studente dal db, richiamandolo tramite la sua PK
	 * Utilizza un metodo GET
	 * @param matricola
	 * @return elimina un oggetto dal db
	 */
	
	
	@GetMapping("/elimina-studente/{matricola}")
	public ModelAndView confermaEliminazionee (@PathVariable(name = "matricola") String matricola) {
		ModelAndView mv = new ModelAndView("elimina-studente");
		mv.addObject("conferma", "Conferma Eliminazione");
		ss.eliminaStudente(matricola);
		log.info("------------conferma eliminazione studente");
		return mv;
	}
	
	
	

	
	
	
}
