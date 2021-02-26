package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;


/**
 * The persistent class for the clienti database table.
 * 
 */
@Entity
@NamedQuery(name="Clienti.findAll", query="SELECT c FROM Clienti c")
public class Clienti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCliente;

	private String codiceFiscale;

	private String cognome;

	private String nome;

	//bi-directional many-to-one association to Registrolibri
	@OneToMany(mappedBy="clienti")
	private List<Registrolibri> registrolibris;

	public Clienti() {
	}

	public Clienti(String codiceFiscale, String cognome, String nome) {
		super();
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
	}
	
	public Clienti(int idCliente, String codiceFiscale, String cognome, String nome) {
		super();
		this.idCliente = idCliente;
		this.codiceFiscale = codiceFiscale;
		this.cognome = cognome;
		this.nome = nome;
	}



	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
		registrolibri.setClienti(this);

		return registrolibri;
	}

	public Registrolibri removeRegistrolibri(Registrolibri registrolibri) {
		getRegistrolibris().remove(registrolibri);
		registrolibri.setClienti(null);

		return registrolibri;
	}

}