package ctrSpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.TurniDao;
import model.Turni;

public class TurniSpring {
	TurniDao tur = new TurniDao();   

	@RequestMapping(value = "/ListaTurni", method = RequestMethod.GET)
	public String ListaDipendenti(ModelMap model) {
		List<Turni> l1 = ritornaListaTurni();
		model.addAttribute("ListaTurni",l1);
		return "ListaTuttiTurni";
	}

//	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//	public ModelAndView hello(@PathVariable("name") String name) {
//		ModelAndView model = new ModelAndView();
//		model.setViewName("hello");
//		model.addObject("msg", name);
//		return model;
//	}
	
	
	private void inserisciTurni(Turni tr) {
		tur.inserisciTurni(tr);
	}
	private List<Turni> ritornaListaTurni(){
		List<Turni> l1 = new ArrayList<>();
		l1=tur.ritornaListaTurni();
		return l1;
	}
	private Turni ritornaTurni(int id) {
		Turni t1 = tur.ritornaTurni(id);
		return t1;
	}
	
	private void aggiornaTurni(Turni t) {
		tur.aggiornaTurni(t);
	}
	
	private void cancellaTurni(Turni t) {
		tur.cancellaTurni(t);
	}
}
