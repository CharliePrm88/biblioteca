package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Libri;
import repository.LibriRepository;

@Service
public class LibriService {

	@Autowired
	private LibriRepository cr;
	
	@Transactional
	public void inserisciLibri(Libri c) {
		
		cr.insertLibri(c);
		
	}
	
	@Transactional
	public void aggiornaLibri(Libri c) {
		
	cr.updateLibri(c);
		
	}
	
	@Transactional
	public void cancellaLibri(int id) {
		
		cr.deleteLibri(id);
		
	}
	
	public Libri ritornaLibri(int id) {
		
		return cr.selectById(id);
		
	}
	
	public List<Libri> ritornaListaLibri() {
		
		return cr.getLibri();
		
	}
}
