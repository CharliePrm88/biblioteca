package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the registrolibri database table.
 * 
 */
@Entity
@NamedQuery(name="Registrolibri.findAll", query="SELECT r FROM Registrolibri r")
public class Registrolibri implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_prestito")
	private Date dataPrestito;

	@Temporal(TemporalType.DATE)
	@Column(name="data_rientro")
	private Date dataRientro;

	@Temporal(TemporalType.DATE)
	@Column(name="data_scadenza")
	private Date dataScadenza;

	//bi-directional many-to-one association to Clienti
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Clienti clienti;

	//bi-directional many-to-one association to Dipendenti
	@ManyToOne
	@JoinColumn(name="matricola")
	private Dipendenti dipendenti;

	//bi-directional many-to-one association to Libri
	@ManyToOne
	@JoinColumn(name="idlibro")
	private Libri libri;

	public Registrolibri() {
	}

	
	
	
	public Registrolibri(Date dataPrestito, Date dataRientro, Date dataScadenza, Clienti clienti, Dipendenti dipendenti,
			Libri libri) {
		super();
		this.dataPrestito = dataPrestito;
		this.dataRientro = dataRientro;
		this.dataScadenza = dataScadenza;
		this.clienti = clienti;
		this.dipendenti = dipendenti;
		this.libri = libri;
	}




	public Registrolibri(int id, Date dataPrestito, Date dataRientro, Date dataScadenza, Clienti clienti,
			Dipendenti dipendenti, Libri libri) {
		super();
		this.id = id;
		this.dataPrestito = dataPrestito;
		this.dataRientro = dataRientro;
		this.dataScadenza = dataScadenza;
		this.clienti = clienti;
		this.dipendenti = dipendenti;
		this.libri = libri;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataPrestito() {
		return this.dataPrestito;
	}

	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public Date getDataRientro() {
		return this.dataRientro;
	}

	public void setDataRientro(Date dataRientro) {
		this.dataRientro = dataRientro;
	}

	public Date getDataScadenza() {
		return this.dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Clienti getClienti() {
		return this.clienti;
	}

	public void setClienti(Clienti clienti) {
		this.clienti = clienti;
	}

	public Dipendenti getDipendenti() {
		return this.dipendenti;
	}

	public void setDipendenti(Dipendenti dipendenti) {
		this.dipendenti = dipendenti;
	}

	public Libri getLibri() {
		return this.libri;
	}

	public void setLibri(Libri libri) {
		this.libri = libri;
	}

}