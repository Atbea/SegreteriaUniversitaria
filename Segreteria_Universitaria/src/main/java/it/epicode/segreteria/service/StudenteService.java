package it.epicode.segreteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.segreteria.model.Studente;
import it.epicode.segreteria.repository.StudenteRepository;

@Service
public class StudenteService {
	
	@Autowired StudenteRepository sr;
	
	public List<Studente> getStudenti(){
		return (List<Studente>) sr.findAll();
	}
	
	public void inserisciStudente (Studente studente) {
		sr.save(studente);
	}
	
	public void eliminaStudente (String matricola) {
		sr.deleteById(matricola);
	}
	
	/*public void modificaStudente(String matricola) {
		sr.findById(matricola);
	}*/
	

}
