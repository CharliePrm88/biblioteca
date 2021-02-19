package ctrSpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.DipendenteDao;
import model.Dipendenti;

@Controller
public class DipendenteSpring {
	DipendenteDao dipe = new DipendenteDao();

	@RequestMapping(value = "/ListaDipendenti", method = RequestMethod.GET)
	public String ListaDipendenti(ModelMap model) {
		List<Dipendenti> l1 = ritornaListaDipendenti();
		model.addAttribute("ListaDipendenti",l1);
		return "/Biblioteca/Dipendente/ListaTuttiDipendenti";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}
	
	
	@RequestMapping("/helloDue")
	public String hello(Model model) {

		model.addAttribute("msg", "CIAO");

		return "helloworld";
	
	}
	
	private void inserisciDipendente(Dipendenti dip) {
		dipe.inserisciDipendente(dip);
	}
	
	private List<Dipendenti> ritornaListaDipendenti(){
		List<Dipendenti> l1 = new ArrayList<>();
		l1=dipe.ritornaListaDipendenti();
		return l1;
	}
	private Dipendenti ritornaDipendenti(int id) {
		Dipendenti d1 = dipe.ritornaDipendenti(id);
		return d1;
	}
	private void aggiornaDipendenti(Dipendenti dip) {
		dipe.aggiornaDipendenti(dip);
	}
	private void cancellaDipendenti(Dipendenti dip) {
		dipe.cancellaDipendenti(dip);
	}
}
