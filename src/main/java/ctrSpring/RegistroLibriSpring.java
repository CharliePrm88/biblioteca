package ctrSpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.RegistroLibriDao;
import model.RegistroLibri;

@Controller
public class RegistroLibriSpring {
	RegistroLibriDao reg = new RegistroLibriDao();   
	@RequestMapping(value = "/ListaRegistroLibri", method = RequestMethod.GET)
	public String ListaRegistroLibri(ModelMap model) {
		List<RegistroLibri> l1 = ritornaListaRegistroLibri();
		model.addAttribute("ListaRegistroLibri",l1);
		return "ListaTuttiRegistri";

	}

//	@RequestMapping(value = "/Biblioteca/RegistroLibri/Ritorna", method = RequestMethod.GET)
//	public ModelAndView ritornaRegistroLibrii(@RequestParam(value="idRegistro",required = true,defaultValue ="0") int id) {
//		ModelAndView model = new ModelAndView();
//		RegistroLibri RegistroLibri = ritornaRegistroLibri(id);
//		model.setViewName("Biblioteca/RegistroLibri/ritornaRegistroLibri");
//		model.addObject("RegistroLibri", RegistroLibri);
//		return model;
//	}
//	
//	@RequestMapping(value = "/Biblioteca/RegistroLibri/Inserisci", method = RequestMethod.POST)
//	public String inserisciRegistroLibri() {
//		
//		return "inserimento.html";
//
//	}
//	
//	@RequestMapping(value = "/Biblioteca/RegistroLibri/Cancella", method = RequestMethod.GET)
//	public ModelAndView cancellaRegistroLibri(@RequestParam(value="matricola") int id) {
//		ModelAndView model = new ModelAndView();
//		RegistroLibri RegistroLibri = ritornaRegistroLibri(id);
//		cancellaRegistroLibri(RegistroLibri);
//		List<RegistroLibri> l1 = ritornaListaRegistroLibri();
//		model.setViewName("/Biblioteca/RegistroLibri/ListaTuttiRegistri");
//		model.addObject("ListaRegistroLibri",l1);
//		return model;
//	}
//	
//	@RequestMapping(value = "/Biblioteca/RegistroLibri/Modifica", method = RequestMethod.GET)
//	public ModelAndView modificaRegistroLibri(@RequestParam(value="matricola") int matricola, @RequestParam(value="nome") String nome, @RequestParam(value="cognome") String cognome, @RequestParam(value="codiceFiscale") String codiceFiscale) {
//		ModelAndView model = new ModelAndView();
//		RegistroLibri RegistroLibri = new RegistroLibri(idlibro,idcliente,matricola,data_prestito,data_scadenza,data_rientro);
//		aggiornaRegistroLibri(RegistroLibri);
//		List<RegistroLibri> l1 = ritornaListaRegistroLibri();
//		model.setViewName("/Biblioteca/RegistroLibri/ListaTuttiRegistroLibri");
//		model.addObject("ListaRegistroLibri",l1);
//		return model;
//	}
	
	private void inserisciregendente(RegistroLibri r) {
		reg.inserisciregendente(r);
	}
	
	private List<RegistroLibri> ritornaListaRegistroLibri(){
		List<RegistroLibri> r1 = new ArrayList<>();
		r1=reg.ritornaListaRegistroLibri();
		return r1;
	}
	
	private RegistroLibri ritornaRegistroLibri(int id) {
		RegistroLibri r1 = reg.ritornaRegistroLibri(id);
		return r1;
	}
	private void aggiornaRegistroLibri(RegistroLibri r) {
		reg.aggiornaRegistroLibri(r);
	}
	private void cancellaRegistroLibri(RegistroLibri r) {
		reg.cancellaRegistroLibri(r);
	}
}
