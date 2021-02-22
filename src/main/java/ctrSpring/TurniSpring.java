package ctrSpring;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.TurniDao;
import model.Turni;

@Controller
public class TurniSpring {
	TurniDao tur = new TurniDao();   

	@RequestMapping(value = "/Biblioteca/Turni/Lista", method = RequestMethod.GET)
	public String ListaTurni(ModelMap model) {
		List<Turni> l1 = ritornaListaTurni();
		model.addAttribute("ListaTurni",l1);
		return "/Biblioteca/Turni/ListaTuttiTurni";
	}


	@RequestMapping(value = "/Biblioteca/Turni/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaTurno(@RequestParam(value="idturno",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		Turni Turno = ritornaTurni(id);
		model.setViewName("Biblioteca/Turni/ritornaTurno");
		model.addObject("Turni", Turno);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Turni/Inserisci", method = RequestMethod.POST)
	public String inserisciTurni() {
		
		return "inserimento.html";

	}
	
	@RequestMapping(value = "/Biblioteca/Turni/Cancella", method = RequestMethod.GET)
	public ModelAndView cancellaTurno(@RequestParam(value="idturno") int id) {
		ModelAndView model = new ModelAndView();
		Turni Turno = ritornaTurni(id);
		cancellaTurni(Turno);
		List<Turni> l1 = ritornaListaTurni();
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
		Turni Turno = new Turni(id,matricola,d1,d2);
		aggiornaTurni(Turno);
		List<Turni> l1 = ritornaListaTurni();
		model.setViewName("/Biblioteca/Turni/ListaTuttiTurni");
		model.addObject("ListaTurni",l1);
		return model;
	}
	
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
