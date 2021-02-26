package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Dipendenti;
import repository.DipendentiRepository;

@Service
public class DipendentiService {

	@Autowired
	private DipendentiRepository dr;
	
	@Transactional
	public void inserisciDipendenti(Dipendenti a) {
		
		dr.insertDipendenti(a);
		
	}
	
	@Transactional
	public void aggiornaDipendenti(Dipendenti a) {
		
	dr.updateDipendenti(a);
		
	}
	
	@Transactional
	public void cancellaDipendenti(int id) {
		
		dr.deleteDipendenti(id);
		
	}
	
	public Dipendenti ritornaDipendenti(int id) {
		
		return dr.selectById(id);
		
	}
	
	public List<Dipendenti> ritornaListaDipendenti() {
		
		return dr.getDipendenti();
		
	}
}
