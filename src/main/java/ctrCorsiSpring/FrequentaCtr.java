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

import dto.CorsiDto;
import dto.FrequentaDto;
import dto.IstruttoreDto;
import ejb.CorsiEjbRemote;
import ejb.FrequentaEjbRemote;
import ejb.IstruttoreEjbRemote;

@Controller
public class FrequentaCtr {

	@Resource(mappedName = "java:jboss/exported/CorsiMaven-0.0.1-SNAPSHOT/FrequentaEjb!ejb.FrequentaEjbRemote")
	private FrequentaEjbRemote fer;
    @Resource(mappedName = "java:jboss/exported/CorsiMaven-0.0.1-SNAPSHOT/CorsiEjb!ejb.CorsiEjbRemote")
	private CorsiEjbRemote cer;
    @Resource(mappedName = "java:jboss/exported/CorsiMaven-0.0.1-SNAPSHOT/IstruttoreEjb!ejb.IstruttoreEjbRemote")
	private IstruttoreEjbRemote ier;
    
    @RequestMapping(value = "/Corsi/Frequenta/Lista", method = RequestMethod.GET)
	public String ListaContoCorrente(ModelMap model) {
    	List<CorsiDto> lc = cer.ritornaListaCorsi();
		List<IstruttoreDto> li = ier.ritornaListaIstruttore();
		model.addAttribute("ListaCorsi", lc);
		model.addAttribute("ListaIstruttore", li);
		return "Corsi/Frequenta/ListaTuttiFrequenta";
	}
    
    @RequestMapping(value = "/Corsi/Frequenta/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaCC(@RequestParam(value="idCliente",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		FrequentaDto c1= fer.ritornaFrequenta(id);
		model.addObject("Frequenta", c1);
		model.setViewName("/ritornaFrequenta.jsp");
		return model;
	}
    
    @RequestMapping(value = "/Corsi/Frequenta/PreInserisci", method = RequestMethod.GET)
	public ModelAndView preinserisciFrequenta() {
		ModelAndView model = new ModelAndView();
		List<CorsiDto> lc = cer.ritornaListaCorsi();
		List<IstruttoreDto> li = ier.ritornaListaIstruttore();
		model.addObject("ListaCorsi", lc);
		model.addObject("ListaIstruttore", li);
		model.setViewName("Corsi/Frequenta/inserimentoFrequenta");
		return model;
	}
    
    @RequestMapping(value = "/Corsi/Frequenta/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciFrequenta(int id, int idCorso,int idDipendente, int idIstruttore) {
		ModelAndView model = new ModelAndView();
		FrequentaDto i= new FrequentaDto(id,idCorso,idDipendente,idIstruttore);
		fer.inserisciFrequenta(i);
		model.setViewName("Inserimento");
		return model;
	}
    
    @RequestMapping(value = "/Corsi/Frequenta/Cancella", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cancellaCliente(int id, int idCorso,int idDipendente, int idIstruttore) {
		ModelAndView model = new ModelAndView();
		FrequentaDto j= new FrequentaDto(id,idCorso,idDipendente,idIstruttore);
		fer.cancellaFrequenta(j);
		List<FrequentaDto> l3 = fer.ritornaListaFrequenta();
		model.addObject("ListaFrequenta", l3);
		model.setViewName("/Corsi/Frequenta/ListaTuttiFrequenta");
		return model;
	}
	
	@RequestMapping(value = "/Corsi/Frequenta/Modifica", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView modificaCliente(int id, int idCorso,int idDipendente, int idIstruttore) {
		ModelAndView model = new ModelAndView();
		FrequentaDto i1= new FrequentaDto(id,idCorso,idDipendente,idIstruttore);
		fer.aggiornaFrequenta(i1);
		List<FrequentaDto> l2 = fer.ritornaListaFrequenta();
		model.addObject("ListaFrequenta", l2);
		model.setViewName("/Corsi/Frequenta/ListaTuttiFrequenta");
		return model;
	}
}
