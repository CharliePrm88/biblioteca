package model;

import java.sql.Date;

public class Turni {
	private int id, matricola;
	private Date data_inizio_turno, data_fine_turno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public Date getData_inizio_turno() {
		return data_inizio_turno;
	}

	public void setData_inizio_turno(Date data_inizio_turno) {
		this.data_inizio_turno = data_inizio_turno;
	}

	public Date getData_fine_turno() {
		return data_fine_turno;
	}

	public void setData_fine_turno(Date data_fine_turno) {
		this.data_fine_turno = data_fine_turno;
	}

	public Turni(int id, int matricola, Date data_inizio_turno, Date data_fine_turno) {
		this.id = id;
		this.matricola = matricola;
		this.data_inizio_turno = data_inizio_turno;
		this.data_fine_turno = data_fine_turno;
	}

}
