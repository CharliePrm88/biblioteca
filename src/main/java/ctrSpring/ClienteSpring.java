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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.ClientiDao;
import model.Clienti;

@Controller
public class ClienteSpring {
	
	ClientiDao cli = new ClientiDao();


	@RequestMapping(value = "/Biblioteca/Cliente/Lista", method = RequestMethod.GET)
	public String ListaClienti(ModelMap model) {
		List<Clienti> l1 = ritornaListaClienti();
		model.addAttribute("ListaClienti",l1);
		return "Biblioteca/Cliente/ListaTuttiClienti";

	}
	
	@RequestMapping(value = "/Biblioteca/Cliente/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaCliente(@RequestParam(value="idCliente",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		Clienti Cliente = ritornaClienti(id);
		model.setViewName("Biblioteca/Cliente/ritornaCliente");
		model.addObject("Clienti", Cliente);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Cliente/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciClienti(String nome, String cognome, String codiceFiscale) {
		ModelAndView model = new ModelAndView();
		Clienti c = new Clienti(nome,cognome,codiceFiscale);
		inserisciCliente(c);
		model.setViewName("Inserimento");
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Cliente/Cancella", method = RequestMethod.GET)
	public ModelAndView cancellaCliente(@RequestParam(value="idCliente") int id) {
		ModelAndView model = new ModelAndView();
		Clienti Cliente = ritornaClienti(id);
		cancellaClienti(Cliente);
		List<Clienti> l1 = ritornaListaClienti();
		model.setViewName("/Biblioteca/Cliente/ListaTuttiClienti");
		model.addObject("ListaClienti",l1);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Cliente/Modifica", method = RequestMethod.GET)
	public ModelAndView modificaCliente(@RequestParam(value="idCliente") int matricola, @RequestParam(value="nome") String nome, @RequestParam(value="cognome") String cognome, @RequestParam(value="codiceFiscale") String codiceFiscale) {
		ModelAndView model = new ModelAndView();
		Clienti Cliente = new Clienti(matricola,nome,cognome,codiceFiscale);
		aggiornaClienti(Cliente);
		List<Clienti> l1 = ritornaListaClienti();
		model.setViewName("/Biblioteca/Cliente/ListaTuttiClienti");
		model.addObject("ListaClienti",l1);
		return model;
	}

	
	private void inserisciCliente(Clienti c) {
		cli.inserisciCliente(c);
	}
	private List<Clienti> ritornaListaClienti() {
		List<Clienti> l1 = new ArrayList<>();
		l1=cli.ritornaListaClienti();
		return l1;
	}
	private Clienti ritornaClienti(int id) {
		Clienti c1 = cli.ritornaClienti(id);
		return c1;
	}
	private void aggiornaClienti(Clienti c) {
		cli.aggiornaClienti(c);
	}
	private void cancellaClienti(Clienti c) {
		cli.cancellaClienti(c);
	}
	
}
