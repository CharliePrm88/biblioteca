package ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.DipendentiService;

import entity.Dipendenti;

@Controller
public class DipendenteSpring {

	@Autowired
	private DipendentiService ds;

	@RequestMapping(value = "/Biblioteca/Dipendente/Lista", method = RequestMethod.GET)
	public ModelAndView listaDipendenti() {
		ModelAndView model = new ModelAndView();
		List<Dipendenti> l1 = ds.ritornaListaDipendenti();
		model.setViewName("/Biblioteca/Dipendente/ListaTuttiDipendenti");
		model.addObject("ListaDipendenti",l1);
		return model;

	}

	@RequestMapping(value = "/Biblioteca/Dipendente/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaDipendente(@RequestParam(value="matricola",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		Dipendenti dipendente = ds.ritornaDipendenti(id);
		model.setViewName("Biblioteca/Dipendente/ritornaDipendente");
		model.addObject("Dipendenti", dipendente);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Dipendente/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciDipendenti(String nome, String cognome, String codiceFiscale) {
		ModelAndView model = new ModelAndView();
		Dipendenti d = new Dipendenti(codiceFiscale,cognome,nome);
		ds.inserisciDipendenti(d);
		model.setViewName("Inserimento");
		return model;

	}
	
	@RequestMapping(value = "/Biblioteca/Dipendente/Cancella", method = RequestMethod.GET)
	public ModelAndView cancellaDipendente(@RequestParam(value="matricola") int id) {
		ModelAndView model = new ModelAndView();
		ds.cancellaDipendenti(id);
		List<Dipendenti> l1 = ds.ritornaListaDipendenti();
		model.setViewName("/Biblioteca/Dipendente/ListaTuttiDipendenti");
		model.addObject("ListaDipendenti",l1);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Dipendente/Modifica", method = RequestMethod.GET)
	public ModelAndView modificaDipendente(@RequestParam(value="matricola") int matricola, @RequestParam(value="nome") String nome, @RequestParam(value="cognome") String cognome, @RequestParam(value="codiceFiscale") String codiceFiscale) {
		ModelAndView model = new ModelAndView();
		Dipendenti dipendente = new Dipendenti(matricola,codiceFiscale,cognome,nome);
		ds.aggiornaDipendenti(dipendente);
		List<Dipendenti> l1 = ds.ritornaListaDipendenti();
		model.setViewName("/Biblioteca/Dipendente/ListaTuttiDipendenti");
		model.addObject("ListaDipendenti",l1);
		return model;
	}
}
