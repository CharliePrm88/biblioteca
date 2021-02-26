package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Registrolibri;
import repository.RegistroLibriRepository;

@Service
public class RegistroLibriService {
	@Autowired
	private RegistroLibriRepository rrl;
	
	@Transactional
	public void inserisciRegistrolibri(Registrolibri c) {
		
		rrl.insertRegistrolibri(c);
		
	}
	
	@Transactional
	public void aggiornaRegistrolibri(Registrolibri c) {
		
	rrl.updateRegistrolibri(c);
		
	}
	
	@Transactional
	public void cancellaRegistrolibri(int id) {
		
		rrl.deleteRegistrolibri(id);
		
	}
	
	public Registrolibri ritornaRegistrolibri(int id) {
		
		return rrl.selectById(id);
		
	}
	
	public List<Registrolibri> ritornaListaRegistrolibri() {
		
		return rrl.getRegistrolibri();
		
	}
}
