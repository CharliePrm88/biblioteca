package ctrRest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Libri;
import service.LibriService;

@RestController
public class LibriSpringRest {
	
	@Autowired
	private LibriService ls;

	@RequestMapping(value = "/BibliotecaRest/Libro/Lista", method = RequestMethod.GET, produces = "application/json")
	public List<Libri> ListaLibri(ModelMap model) {
		List<Libri> l1 = ls.ritornaListaLibri();
		return l1;

	}


	@RequestMapping(value = "/BibliotecaRest/Libro/Ritorna", method = RequestMethod.GET, produces = "application/json")
	public Libri ritornaLibro(@RequestParam(value="idLibro",required = true,defaultValue ="0") int id) {
		Libri Libri = ls.ritornaLibri(id);
		return Libri;
	}
	
	@RequestMapping(value = "/BibliotecaRest/Libro/Inserisci", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void inserisciLibro(String annoDiStampa,int numeroPagine,String titolo, String genere, String autore, String ISBN, String casaEditrice,String posizione) {
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
	}
	
	@RequestMapping(value = "/BibliotecaRest/Libro/Cancella", method = RequestMethod.DELETE, consumes = "application/json")
	public void cancellaLibri(@RequestParam(value="idlibro") int id) {
		ls.cancellaLibri(id);
	}
	
	@RequestMapping(value = "/BibliotecaRest/Libro/Modifica", method = RequestMethod.PUT)
	public void modificaLibri(@RequestParam(value="idlibro") int id, @RequestParam(value="annoDiStampa") String annoDiStampa, @RequestParam(value="numeroPagine") int numeroPagine, @RequestParam(value="titolo") String titolo, @RequestParam(value="genere") String genere, @RequestParam(value="autore") String autore, @RequestParam(value="ISBN") String isbn, @RequestParam(value="casaEditrice") String casaEditrice, @RequestParam(value="posizione") String posizione) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = null;
		try {
			date1 = sdf.parse(annoDiStampa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d1 = new Date(date1.getTime());
		Libri libri = new Libri(id,d1,autore,casaEditrice,genere,isbn,numeroPagine,posizione,titolo);
		ls.aggiornaLibri(libri);
	}
	
}
