package it.epicode.segreteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.segreteria.model.CorsoDiLaurea;
import it.epicode.segreteria.repository.CorsoDiLaureaRepository;


@Service
public class CorsoDiLaureaService {
	
	@Autowired CorsoDiLaureaRepository clr;
	
	public List<CorsoDiLaurea> getCorsi() {
		return (List<CorsoDiLaurea>) clr.findAll();
	}
	
	public void inserisciCorso (CorsoDiLaurea corso) {
		clr.save(corso);
	}
	
	public void eliminaCorso (String codice) {
		clr.deleteById(codice);
	}
	
	

}
