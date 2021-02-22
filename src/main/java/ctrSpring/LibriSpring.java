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

	@RequestMapping(value = "/Biblioteca/Libro/Lista", method = RequestMethod.GET)
	public String ListaLibri(ModelMap model) {
		List<Libri> l1 = ritornaListaLibri();
		model.addAttribute("ListaLibri",l1);
		return "/Biblioteca/Libro/ListaTuttiLibri";

	}


	@RequestMapping(value = "/Biblioteca/Libro/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaLibri(@RequestParam(value="idLibro",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		Libri Libri = ritornaLibro(id);
		model.setViewName("Biblioteca/Libri/ritornaLibri");
		model.addObject("Libri", Libri);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Libro/Inserisci", method = RequestMethod.POST)
	public String inserisciLibri() {
		
		return "inserimento.html";

	}
	
	@RequestMapping(value = "/Biblioteca/Libro/Cancella", method = RequestMethod.GET)
	public ModelAndView cancellaLibri(@RequestParam(value="idlibro") int id) {
		ModelAndView model = new ModelAndView();
		Libri Libri = ritornaLibro(id);
		cancellaLibri(Libri);
		List<Libri> l1 = ritornaListaLibri();
		model.setViewName("/Biblioteca/Libro/ListaTuttiLibri");
		model.addObject("ListaLibri",l1);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Libro/Modifica", method = RequestMethod.GET)
	public ModelAndView modificaLibri(@RequestParam(value="idlibro") int id, @RequestParam(value="annoDiStampa") String annoDiStampa, @RequestParam(value="numeroPagine") int numeroPagine, @RequestParam(value="titolo") String titolo, @RequestParam(value="genere") String genere, @RequestParam(value="autore") String autore, @RequestParam(value="ISBN") String isbn, @RequestParam(value="casaEditrice") String casaEditrice, @RequestParam(value="posizione") String posizione) {
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
		Libri Libri = new Libri(id,d1,numeroPagine,titolo,genere,autore,isbn,casaEditrice,posizione);
		aggiornaLibri(Libri);
		List<Libri> l1 = ritornaListaLibri();
		model.setViewName("/Biblioteca/Libro/ListaTuttiLibri");
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
