package entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the libri database table.
 * 
 */
@Entity
@NamedQuery(name="Libri.findAll", query="SELECT l FROM Libri l")
public class Libri implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLibro;

	@Temporal(TemporalType.DATE)
	private Date annoDiStampa;

	private String autore;

	private String casaeditrice;

	private String genere;

	private String isbn;

	private int numeroPagine;

	private String posizione;

	private String titolo;

	//bi-directional many-to-one association to Registrolibri
	@OneToMany(mappedBy="libri")
	@JsonIgnore
	private List<Registrolibri> registrolibris;

	public Libri() {
	}

	
	public Libri(int idLibro, Date annoDiStampa, String autore, String casaeditrice, String genere, String isbn,
			int numeroPagine, String posizione, String titolo) {
		super();
		this.idLibro = idLibro;
		this.annoDiStampa = annoDiStampa;
		this.autore = autore;
		this.casaeditrice = casaeditrice;
		this.genere = genere;
		this.isbn = isbn;
		this.numeroPagine = numeroPagine;
		this.posizione = posizione;
		this.titolo = titolo;
	}



	public Libri(Date annoDiStampa, String autore, String casaeditrice, String genere, String isbn, int numeroPagine,
			String posizione, String titolo) {
		super();
		this.annoDiStampa = annoDiStampa;
		this.autore = autore;
		this.casaeditrice = casaeditrice;
		this.genere = genere;
		this.isbn = isbn;
		this.numeroPagine = numeroPagine;
		this.posizione = posizione;
		this.titolo = titolo;
	}



	public int getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public Date getAnnoDiStampa() {
		return this.annoDiStampa;
	}

	public void setAnnoDiStampa(Date annoDiStampa) {
		this.annoDiStampa = annoDiStampa;
	}

	public String getAutore() {
		return this.autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getCasaeditrice() {
		return this.casaeditrice;
	}

	public void setCasaeditrice(String casaeditrice) {
		this.casaeditrice = casaeditrice;
	}

	public String getGenere() {
		return this.genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumeroPagine() {
		return this.numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public String getPosizione() {
		return this.posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Registrolibri> getRegistrolibris() {
		return this.registrolibris;
	}

	public void setRegistrolibris(List<Registrolibri> registrolibris) {
		this.registrolibris = registrolibris;
	}

	public Registrolibri addRegistrolibri(Registrolibri registrolibri) {
		getRegistrolibris().add(registrolibri);
		registrolibri.setLibri(this);

		return registrolibri;
	}

	public Registrolibri removeRegistrolibri(Registrolibri registrolibri) {
		getRegistrolibris().remove(registrolibri);
		registrolibri.setLibri(null);

		return registrolibri;
	}

}