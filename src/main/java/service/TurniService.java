package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Turni;
import repository.TurniRepository;

@Service
public class TurniService {

	@Autowired
	private TurniRepository cr;
	
	@Transactional
	public void inserisciTurni(Turni c) {
		
		cr.insertTurni(c);
		
	}
	
	@Transactional
	public void aggiornaTurni(Turni c) {
		
	cr.updateTurni(c);
		
	}
	
	@Transactional
	public void cancellaTurni(int id) {
		
		cr.deleteTurni(id);
		
	}
	
	public Turni ritornaTurni(int id) {
		
		return cr.selectById(id);
		
	}
	
	public List<Turni> ritornaListaTurni() {
		
		return cr.getTurni();
		
	}
}
