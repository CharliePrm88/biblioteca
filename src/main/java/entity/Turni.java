package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the turni database table.
 * 
 */
@Entity
@NamedQuery(name="Turni.findAll", query="SELECT t FROM Turni t")
public class Turni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine_turno")
	private Date dataFineTurno;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio_turno")
	private Date dataInizioTurno;

	//bi-directional many-to-one association to Dipendenti
	@ManyToOne
	@JoinColumn(name="matricola")
	private Dipendenti dipendenti;

	public Turni() {
	}
	
	public Turni(int id, Date dataFineTurno, Date dataInizioTurno, Dipendenti dipendenti) {
		super();
		this.id = id;
		this.dataFineTurno = dataFineTurno;
		this.dataInizioTurno = dataInizioTurno;
		this.dipendenti = dipendenti;
	}

	public Turni(Date dataFineTurno, Date dataInizioTurno, Dipendenti dipendenti) {
		super();
		this.dataFineTurno = dataFineTurno;
		this.dataInizioTurno = dataInizioTurno;
		this.dipendenti = dipendenti;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataFineTurno() {
		return this.dataFineTurno;
	}

	public void setDataFineTurno(Date dataFineTurno) {
		this.dataFineTurno = dataFineTurno;
	}

	public Date getDataInizioTurno() {
		return this.dataInizioTurno;
	}

	public void setDataInizioTurno(Date dataInizioTurno) {
		this.dataInizioTurno = dataInizioTurno;
	}

	public Dipendenti getDipendenti() {
		return this.dipendenti;
	}

	public void setDipendenti(Dipendenti dipendenti) {
		this.dipendenti = dipendenti;
	}

}