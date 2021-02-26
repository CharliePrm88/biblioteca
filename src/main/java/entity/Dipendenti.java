package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dipendenti database table.
 * 
 */
@Entity
@NamedQuery(name="Dipendenti.findAll", query="SELECT d FROM Dipendenti d")
public class Dipendenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int matricola;

	private String codiceFiscale;

	private String cognome;

	private String nome;

	//bi-directional many-to-one association to Registrolibri
	@OneToMany(mappedBy="dipendenti")
	private List<Registrolibri> registrolibris;

	//bi-directional many-to-one association to Turni
	@OneToMany(mappedBy="dipendenti")
	private List<Turni> turnis;

	public Dipendenti() {
	}

	public Dipendenti( String codiceFiscale, String cognome, String nome) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
	}
	
	public Dipendenti(int matricola, String codiceFiscale, String cognome, String nome) {
		super();
		this.matricola = matricola;
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
	}

	public int getMatricola() {
		return this.matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Registrolibri> getRegistrolibris() {
		return this.registrolibris;
	}

	public void setRegistrolibris(List<Registrolibri> registrolibris) {
		this.registrolibris = registrolibris;
	}

	public Registrolibri addRegistrolibri(Registrolibri registrolibri) {
		getRegistrolibris().add(registrolibri);
		registrolibri.setDipendenti(this);

		return registrolibri;
	}

	public Registrolibri removeRegistrolibri(Registrolibri registrolibri) {
		getRegistrolibris().remove(registrolibri);
		registrolibri.setDipendenti(null);

		return registrolibri;
	}

	public List<Turni> getTurnis() {
		return this.turnis;
	}

	public void setTurnis(List<Turni> turnis) {
		this.turnis = turnis;
	}

	public Turni addTurni(Turni turni) {
		getTurnis().add(turni);
		turni.setDipendenti(this);

		return turni;
	}

	public Turni removeTurni(Turni turni) {
		getTurnis().remove(turni);
		turni.setDipendenti(null);

		return turni;
	}

}