package it.epicode.segreteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.epicode.segreteria.model.CorsoDiLaurea;
import it.epicode.segreteria.repository.CorsoDiLaureaRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *@author Simona Tedesco 
 * 
 */

@Slf4j
@Component
@Order(1)
public class UniversitaRunner implements CommandLineRunner{

	@Autowired CorsoDiLaureaRepository clr;
	@Autowired @Qualifier("1PSI") CorsoDiLaurea c1;
	@Autowired @Qualifier("2EC_A") CorsoDiLaurea c2;
	@Autowired @Qualifier("3GIUR") CorsoDiLaurea c3;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		clr.save(c1);
		log.info("-----------corso1");
		clr.save(c2);
		log.info("-----------corso2");
		clr.save(c3);
		log.info("-----------corso3");
		
	
		
	}

}
