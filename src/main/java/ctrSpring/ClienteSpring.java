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

import dao.ClientiDao;
import model.Clienti;

@Controller
public class ClienteSpring {
	
	ClientiDao cli = new ClientiDao();


	@RequestMapping(value = "/ListaClienti", method = RequestMethod.GET)
	public String ListaClienti(ModelMap model) {
		List<Clienti> l1 = ritornaListaClienti();
		model.addAttribute("ListaClienti",l1);
		return "ListaTuttiClienti";

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
