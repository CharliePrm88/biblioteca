package model;

import java.sql.Date;

public class Libri {
	private int idlibro, numeroPagine;
	private String titolo, genere, autore, ISBN, casaEditrice, posizione;
	private Date annoDiStampa;
	public Libri(int idlibro, Date annoDiStampa, int numeroPagine, String titolo, String genere, String autore,
			String ISBN, String casaEditrice, String posizione) {
		this.idlibro = idlibro;
		this.annoDiStampa = annoDiStampa;
		this.numeroPagine = numeroPagine;
		this.titolo = titolo;
		this.genere = genere;
		this.autore = autore;
		this.ISBN = ISBN;
		this.casaEditrice = casaEditrice;
		this.posizione = posizione;
	}
	
	public Libri(Date annoDiStampa, int numeroPagine, String titolo, String genere, String autore,
			String ISBN, String casaEditrice, String posizione) {
		this.annoDiStampa = annoDiStampa;
		this.numeroPagine = numeroPagine;
		this.titolo = titolo;
		this.genere = genere;
		this.autore = autore;
		this.ISBN = ISBN;
		this.casaEditrice = casaEditrice;
		this.posizione = posizione;
	}

	public int getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}

	public Date getAnnoDiStampa() {
		return annoDiStampa;
	}

	public void setAnnoDiStampa(Date annoDiStampa) {
		this.annoDiStampa = annoDiStampa;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getCasaEditrice() {
		return casaEditrice;
	}

	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

}
