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

//	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//	public ModelAndView hello(@PathVariable("name") String name) {
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("hello");
//		model.addObject("msg", name);
//
//		return model;
//
//	}
	
	
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
