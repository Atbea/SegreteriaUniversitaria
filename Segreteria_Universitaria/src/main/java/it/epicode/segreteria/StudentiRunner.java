package it.epicode.segreteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.epicode.segreteria.model.Studente;
import it.epicode.segreteria.repository.StudenteRepository;
import lombok.extern.slf4j.Slf4j;


/**
 * 
 * 
 *@author Simona Tedesco 
 */



@Slf4j
@Component
@Order(2)
public class StudentiRunner implements CommandLineRunner {
	

	@Autowired StudenteRepository sr;
	@Autowired @Qualifier("studente1") Studente s1;
	@Autowired @Qualifier("studente2") Studente s2;
	@Autowired @Qualifier("studente3") Studente s3;
	
	@Override
	public void run(String... args) throws Exception {
	
		sr.save(s1);
		log.info("-----------studente1");
		sr.save(s2);
		log.info("-----------studente2");
		sr.save(s3);
		log.info("-----------studente3");
		
	}

}
