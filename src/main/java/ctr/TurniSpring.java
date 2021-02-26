package ctr;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import entity.Turni;
import service.TurniService;
import service.DipendentiService;

@Controller
public class TurniSpring {
	@Autowired
	private TurniService ts;   
	private DipendentiService ds;
	
	@RequestMapping(value = "/Biblioteca/Turni/Lista", method = RequestMethod.GET)
	public String ListaTurni(ModelMap model) {
		List<Turni> l1 = ts.ritornaListaTurni();
		model.addAttribute("ListaTurni",l1);
		return "/Biblioteca/Turni/ListaTuttiTurni";
	}


	@RequestMapping(value = "/Biblioteca/Turni/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaTurno(@RequestParam(value="idturno",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		Turni Turno = ts.ritornaTurni(id);
		model.setViewName("Biblioteca/Turni/ritornaTurno");
		model.addObject("Turni", Turno);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Turni/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciTurni(String data_inizio, String data_fine, int matricola) {
		ModelAndView model = new ModelAndView();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data_inizio1 = null;
		java.util.Date data_fine1= null;
		try {
			data_inizio1 = sdf.parse(data_inizio);
			data_fine1= sdf.parse(data_fine);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d1 = new Date(data_inizio1.getTime());
		java.sql.Date d2 = new Date(data_fine1.getTime());
		Turni Turno = new Turni(d2,d1,ds.ritornaDipendenti(matricola));
		ts.inserisciTurni(Turno);
		model.setViewName("Inserimento");
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Turni/Cancella", method = RequestMethod.GET)
	public ModelAndView cancellaTurno(@RequestParam(value="idturno") int id) {
		ModelAndView model = new ModelAndView();
		ts.cancellaTurni(id);
		List<Turni> l1 = ts.ritornaListaTurni();
		model.setViewName("/Biblioteca/Turni/ListaTuttiTurni");
		model.addObject("ListaTurni",l1);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Turni/Modifica", method = RequestMethod.GET)
	public ModelAndView modificaTurno(@RequestParam(value="idturno") int id, @RequestParam(value="matricola") int matricola, @RequestParam(value="data_inizio") String data_inizio, @RequestParam(value="data_fine") String data_fine ) {
		ModelAndView model = new ModelAndView();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data_inizio1 = null;
		java.util.Date data_fine1= null;
		try {
			data_inizio1 = sdf.parse(data_inizio);
			data_fine1= sdf.parse(data_fine);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d1 = new Date(data_inizio1.getTime());
		java.sql.Date d2 = new Date(data_fine1.getTime());
		Turni Turno = new Turni(id,d2,d1,ds.ritornaDipendenti(matricola));
		ts.aggiornaTurni(Turno);
		List<Turni> l1 = ts.ritornaListaTurni();
		model.setViewName("/Biblioteca/Turni/ListaTuttiTurni");
		model.addObject("ListaTurni",l1);
		return model;
	}
	
}
