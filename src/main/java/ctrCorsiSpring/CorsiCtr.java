package ctrCorsiSpring;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import ejb.CorsiEjbRemote;

@Controller
public class CorsiCtr {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Resource(mappedName = "java:jboss/exported/CorsiMaven-0.0.1-SNAPSHOT/CorsiEjb!ejb.CorsiEjbRemote")
	private CorsiEjbRemote fer;
	
	@RequestMapping(value = "/Corsi/Corso/Lista", method = RequestMethod.GET)
	public String ListaCorsi(ModelMap model) {
		List<CorsiDto> l1 = fer.ritornaListaCorsi();
		model.addAttribute("ListaCorsi", l1);
		return "/Corsi/Corso/ListaTuttiCorsi";
	}
	
	@RequestMapping(value = "/Corsi/Corso/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaCorsi(@RequestParam(value="id",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		CorsiDto c1= fer.ritornaCorsi(id);
		model.setViewName("Corsi/Corso/ritornaCorsi");
		model.addObject("Corsi", c1);
		return model;
	}
	
	@RequestMapping(value = "/Corsi/Corso/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciCorsi(String data_inizio, String data_fine, String nome, int id) {
		ModelAndView model = new ModelAndView();
		java.util.Date date1 = null;
		java.util.Date date2 = null;
		try {
			date1 = sdf.parse(data_inizio);
			date2 = sdf.parse(data_fine);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d1 = new Date(date1.getTime());
		java.sql.Date d2 = new Date(date2.getTime());
		CorsiDto i= new CorsiDto(id,nome, d1,d2);
		fer.inserisciCorsi(i);
		model.setViewName("Inserimento");
		return model;
	}
	
	@RequestMapping(value = "/Corsi/Corso/Cancella", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cancellaCorsi(String data_inizio, String data_fine, int id, String nome) {
		ModelAndView model = new ModelAndView();
		java.util.Date date5 = null;
		java.util.Date date6 = null;
		try {
			date5 = sdf.parse(data_inizio);
			date6 = sdf.parse(data_fine);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d5 = new Date(date5.getTime());
		java.sql.Date d6 = new Date(date6.getTime());
		CorsiDto j= new CorsiDto(id,nome, d5,d6);
		fer.cancellaCorsi(j);
		List<CorsiDto> l3 = fer.ritornaListaCorsi();
		model.setViewName("/Corsi/Corso/ListaTuttiCorsi");
		model.addObject("ListaCorsi",l3);
		return model;
	}
	@RequestMapping(value = "/Corsi/Corso/Modifica", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView modificaCorso(String data_inizio, String data_fine, int id, String nome) {
		ModelAndView model = new ModelAndView();
		java.util.Date date3 = null;
		java.util.Date date4 = null;
		try {
			date3 = sdf.parse(data_inizio);
			date4 = sdf.parse(data_fine);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d3 = new Date(date3.getTime());
		java.sql.Date d4 = new Date(date4.getTime());
		CorsiDto i1= new CorsiDto(id,nome, d3,d4);
		fer.aggiornaCorsi(i1);
		List<CorsiDto> l2 = fer.ritornaListaCorsi();
		model.addObject("ListaCorsi", l2);
		model.setViewName("/Corsi/Corso/ListaTuttiCorsi");
		return model;
	}
}
