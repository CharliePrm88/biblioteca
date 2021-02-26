package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Clienti;
import repository.ClientiRepository;

@Service
public class ClientiService {

	@Autowired
	private ClientiRepository cr;
	
	@Transactional
	public void inserisciClienti(Clienti c) {
		
		cr.insertClienti(c);
		
	}
	
	@Transactional
	public void aggiornaClienti(Clienti c) {
		
	cr.updateClienti(c);
		
	}
	
	@Transactional
	public void cancellaClienti(int id) {
		
		cr.deleteClienti(id);
		
	}
	
	public Clienti ritornaClienti(int id) {
		
		return cr.selectById(id);
		
	}
	
	public List<Clienti> ritornaListaClienti() {
		
		return cr.getClienti();
		
	}
}
