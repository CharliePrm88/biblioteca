package ctrCorsiSpring;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import dto.IstruttoreDto;
import ejb.IstruttoreEjbRemote;

@Controller
public class IstruttoreCtr {
	@Resource(mappedName = "java:jboss/exported/CorsiMaven-0.0.1-SNAPSHOT/IstruttoreEjb!ejb.IstruttoreEjbRemote")
	private IstruttoreEjbRemote ier;
	
	@RequestMapping(value = "/Corsi/Istruttore/Lista", method = RequestMethod.GET)
	public String ListaContoCorrente(ModelMap model) {
		List<IstruttoreDto> l1 = ier.ritornaListaIstruttore();
		model.addAttribute("ListaIstruttore", l1);
		return "Corsi/Istruttore/ListaTuttiIstruttore";
	}
	
	@RequestMapping(value = "/Corsi/Istruttore/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaCC(@RequestParam(value="matricola",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		IstruttoreDto c1= ier.ritornaIstruttore(id);
		model.addObject("Istruttore", c1);
		model.setViewName("Corsi/Istruttore/ritornaIstruttore");
		return model;
	}
	
	@RequestMapping(value = "/Corsi/Istruttore/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciContoCorrente(String nome, String cognome,String codiceFiscale, int matricola) {
		ModelAndView model = new ModelAndView();
		IstruttoreDto i= new IstruttoreDto(matricola,nome,cognome,codiceFiscale);
		ier.inserisciIstruttore(i);
		model.setViewName("Inserimento");
		return model;
	}
	
	@RequestMapping(value = "/Corsi/Istruttore/Cancella", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cancellaCliente(int matricola) {
		ModelAndView model = new ModelAndView();
		IstruttoreDto j= new IstruttoreDto(matricola,null,null,null);
		ier.cancellaIstruttore(j);
		List<IstruttoreDto> l3 = ier.ritornaListaIstruttore();
		model.addObject("ListaIstruttore", l3);
		model.setViewName("/Corsi/Frequenta/ListaTuttiFrequenta");
		return model;
	}
	
	@RequestMapping(value = "/Corsi/Istruttore/Modifica", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView modificaCliente(String nome, String cognome,String codiceFiscale, int matricola) {
		ModelAndView model = new ModelAndView();
		IstruttoreDto i1= new IstruttoreDto(matricola,nome,cognome,codiceFiscale);
		ier.aggiornaIstruttore(i1);
		List<IstruttoreDto> l2 = ier.ritornaListaIstruttore();
		model.addObject("ListaIstruttore", l2);
		model.setViewName("/Corsi/Frequenta/ListaTuttiFrequenta");
		return model;
	}
}
