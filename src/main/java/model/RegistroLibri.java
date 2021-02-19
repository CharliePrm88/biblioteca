package model;

import java.sql.Date;

public class RegistroLibri {
	private int id, idlibro, idcliente, matricola;
	private Date data_prestito, data_scadenza, data_rientro;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public Date getData_prestito() {
		return data_prestito;
	}

	public void setData_prestito(Date data_prestito) {
		this.data_prestito = data_prestito;
	}

	public Date getData_scadenza() {
		return data_scadenza;
	}

	public void setData_scadenza(Date data_scadenza) {
		this.data_scadenza = data_scadenza;
	}

	public Date getData_rientro() {
		return data_rientro;
	}

	public void setData_rientro(Date data_rientro) {
		this.data_rientro = data_rientro;
	}

	public RegistroLibri(int id, int idlibro, int idcliente, int matricola, Date data_prestito, Date data_scadenza,
			Date data_rientro) {
		this.id = id;
		this.idlibro = idlibro;
		this.idcliente = idcliente;
		this.matricola = matricola;
		this.data_prestito = data_prestito;
		this.data_scadenza = data_scadenza;
		this.data_rientro = data_rientro;
	}
	
	public RegistroLibri(int idlibro, int idcliente, int matricola, Date data_prestito, Date data_scadenza,
			Date data_rientro) {
		this.idlibro = idlibro;
		this.idcliente = idcliente;
		this.matricola = matricola;
		this.data_prestito = data_prestito;
		this.data_scadenza = data_scadenza;
		this.data_rientro = data_rientro;
	}
}
