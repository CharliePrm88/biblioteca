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

import dao.RegistroLibriDao;
import model.RegistroLibri;

@Controller
public class RegistroLibriSpring {
	RegistroLibriDao reg = new RegistroLibriDao();   
	@RequestMapping(value = "/ListaRegistroLibri", method = RequestMethod.GET)
	public String ListaDipendenti(ModelMap model) {
		List<RegistroLibri> l1 = ritornaListaRegistroLibri();
		model.addAttribute("ListaRegistroLibri",l1);
		return "ListaTuttiRegistri";

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
