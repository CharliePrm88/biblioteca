package ctr;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import entity.Libri;
import service.LibriService;

@Controller
public class LibriSpring {
	
	@Autowired
	private LibriService ls;

	@RequestMapping(value = "/Biblioteca/Libro/Lista", method = RequestMethod.GET)
	public String ListaLibri(ModelMap model) {
		List<Libri> l1 = ls.ritornaListaLibri();
		model.addAttribute("ListaLibri",l1);
		return "/Biblioteca/Libro/ListaTuttiLibri";

	}


	@RequestMapping(value = "/Biblioteca/Libro/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaLibro(@RequestParam(value="idLibro",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		Libri Libri = ls.ritornaLibri(id);
		model.setViewName("Biblioteca/Libri/ritornaLibri");
		model.addObject("Libri", Libri);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Libro/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciLibro(String annoDiStampa,int numeroPagine,String titolo, String genere, String autore, String ISBN, String casaEditrice,String posizione) {
		ModelAndView model = new ModelAndView();
		model.setViewName("Inserimento");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = null;
		try {
			date1 = sdf.parse(annoDiStampa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d1 = new Date(date1.getTime());
		Libri libri = new Libri(d1,autore,casaEditrice,genere,ISBN,numeroPagine,posizione,titolo);
		ls.inserisciLibri(libri);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Libro/Cancella", method = RequestMethod.GET)
	public ModelAndView cancellaLibri(@RequestParam(value="idlibro") int id) {
		ModelAndView model = new ModelAndView();
		ls.cancellaLibri(id);
		List<Libri> l1 = ls.ritornaListaLibri();
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
		Libri libri = new Libri(id,d1,autore,casaEditrice,genere,isbn,numeroPagine,posizione,titolo);
		ls.aggiornaLibri(libri);
		List<Libri> l1 = ls.ritornaListaLibri();
		model.setViewName("/Biblioteca/Libro/ListaTuttiLibri");
		model.addObject("ListaLibri",l1);
		return model;
	}
	
}
