package ctrSpring;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import dao.LibriDao;
import model.Libri;

@Controller
public class LibriSpring {
	LibriDao cli = new LibriDao();

	@RequestMapping(value = "/ListaLibri", method = RequestMethod.GET)
	public String ListaLibri(ModelMap model) {
		List<Libri> l1 = ritornaListaLibri();
		model.addAttribute("ListaLibri",l1);
		return "ListaTuttiLibri";

	}


	@RequestMapping(value = "/Biblioteca/Dipendente/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaDipendente(@RequestParam(value="idLibro",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		Libri dipendente = ritornaLibro(id);
		model.setViewName("Biblioteca/Dipendente/ritornaDipendente");
		model.addObject("Libri", dipendente);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Dipendente/Inserisci", method = RequestMethod.POST)
	public String inserisciLibri() {
		
		return "inserimento.html";

	}
	
	@RequestMapping(value = "/Biblioteca/Dipendente/Cancella", method = RequestMethod.GET)
	public ModelAndView cancellaDipendente(@RequestParam(value="idLibro") int id) {
		ModelAndView model = new ModelAndView();
		Libri dipendente = ritornaLibro(id);
		cancellaLibri(dipendente);
		List<Libri> l1 = ritornaListaLibri();
		model.setViewName("/Biblioteca/Dipendente/ListaTuttiLibri");
		model.addObject("ListaLibri",l1);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Dipendente/Modifica", method = RequestMethod.GET)
	public ModelAndView modificaDipendente(@RequestParam(value="idLibro") int id, @RequestParam(value="annoDiStampa") String annoDiStampa, @RequestParam(value="numeroPagine") int numeroPagine, @RequestParam(value="titolo") String titolo, @RequestParam(value="genere") String genere, @RequestParam(value="autore") String autore, @RequestParam(value="isbn") String isbn, @RequestParam(value="casaEditrice") String casaEditrice, @RequestParam(value="posizione") String posizione) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = null;
		try {
			date1 = sdf.parse(annoDiStampa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d1 = new Date(date1.getTime());
		ModelAndView model = new ModelAndView();
		Libri dipendente = new Libri(id,d1,numeroPagine,titolo,genere,autore,isbn,casaEditrice,posizione);
		aggiornaLibri(dipendente);
		List<Libri> l1 = ritornaListaLibri();
		model.setViewName("/Biblioteca/Dipendente/ListaTuttiLibri");
		model.addObject("ListaLibri",l1);
		return model;
	}
	
	private void inserisciLibri(Libri lib) {
		cli.inserisciLibri(lib);
	}
	private List<Libri> ritornaListaLibri(){
		List<Libri> l1 = new ArrayList<>();
		l1=cli.ritornaListaLibri();
		return l1;
	}	
	private Libri ritornaLibro(int id) {
		Libri l1=cli.ritornaLibro(id);
		return l1;
	}
	private void aggiornaLibri(Libri lib) {
		cli.aggiornaLibri(lib);
	}
	private void cancellaLibri(Libri lib) {
		cli.cancellaLibri(lib);
	}
}
