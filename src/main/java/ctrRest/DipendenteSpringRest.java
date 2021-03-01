package ctrRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.DipendentiService;

import entity.Dipendenti;

@RestController
public class DipendenteSpringRest {

	@Autowired
	private DipendentiService ds;

	@RequestMapping(value = "/BibliotecaRest/Dipendente/Lista", method = RequestMethod.GET, produces = "application/json")
	public List<Dipendenti> listaDipendenti() {
		List<Dipendenti> l1 = ds.ritornaListaDipendenti();
		return l1;

	}

	@RequestMapping(value = "/BibliotecaRest/Dipendente/Ritorna", method = RequestMethod.GET, produces = "application/json")
	public Dipendenti ritornaDipendente(@RequestParam(value="matricola",required = true,defaultValue ="0") int id) {
		Dipendenti dipendente = ds.ritornaDipendenti(id);
		return dipendente;
	}
	
	@RequestMapping(value = "/BibliotecaRest/Dipendente/Inserisci", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void inserisciDipendenti(String nome, String cognome, String codiceFiscale) {
		Dipendenti d = new Dipendenti(codiceFiscale,cognome,nome);
		ds.inserisciDipendenti(d);
	}
	
	@RequestMapping(value = "/BibliotecaRest/Dipendente/Cancella", method = RequestMethod.DELETE,consumes = "application/json")
	public void cancellaDipendente(@RequestParam(value="matricola") int id) {
		ds.cancellaDipendenti(id);
	}
	
	@RequestMapping(value = "/BibliotecaRest/Dipendente/Modifica", method = RequestMethod.PUT, consumes = "application/json")
	public void modificaDipendente(@RequestParam(value="matricola") int matricola, @RequestParam(value="nome") String nome, @RequestParam(value="cognome") String cognome, @RequestParam(value="codiceFiscale") String codiceFiscale) {
		Dipendenti dipendente = new Dipendenti(matricola,codiceFiscale,cognome,nome);
		ds.aggiornaDipendenti(dipendente);
		}
}
