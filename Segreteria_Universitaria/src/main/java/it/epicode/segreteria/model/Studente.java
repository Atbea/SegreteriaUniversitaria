package it.epicode.segreteria.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Entity
@Data
@NoArgsConstructor
public class Studente {
	

	@Id
	protected String matricola;
	@NotNull
	protected String nome;
	@NotNull
	protected String cognome;
	@NotNull
	@DateTimeFormat
	protected String dataN;
	@NotNull
	@Email
	protected String email;
	@NotNull
	protected String indirizzoR;
	@NotNull
	protected String cittaR;
	@ManyToOne
	@JoinColumn (name = "corsoDiLaurea")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	protected CorsoDiLaurea corsoDiLaurea;
	
	
	

}
