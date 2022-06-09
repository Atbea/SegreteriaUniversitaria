package it.epicode.segreteria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CorsoDiLaurea {
	
	@Id
	protected String codice;
	@NotNull
	protected String nome;
	@NotNull
	protected String indirizzo;
	@NotNull
	@Min(value=10)
	protected int numEsami;
	@OneToMany(mappedBy = "corsoDiLaurea", cascade = CascadeType.ALL)
	protected List<Studente> corsisti = new ArrayList<>();

	
}

