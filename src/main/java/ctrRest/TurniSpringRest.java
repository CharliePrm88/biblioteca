package ctrRest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Turni;
import service.TurniService;
import service.DipendentiService;

@Controller
public class TurniSpringRest {
	@Autowired
	private TurniService ts;   
	private DipendentiService ds;
	
	@RequestMapping(value = "/BibliotecaRest/Turni/Lista", method = RequestMethod.GET, produces = "application/json")
	public List<Turni> ListaTurni(ModelMap model) {
		List<Turni> l1 = ts.ritornaListaTurni();
		return l1;
	}


	@RequestMapping(value = "/BibliotecaRest/Turni/Ritorna", method = RequestMethod.GET, produces = "application/json")
	public Turni ritornaTurno(@RequestParam(value="idturno",required = true,defaultValue ="0") int id) {
		Turni Turno = ts.ritornaTurni(id);
		return Turno;
	}
	
	@RequestMapping(value = "/BibliotecaRest/Turni/Inserisci", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void inserisciTurni(String data_inizio, String data_fine, int matricola) {
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
	}
	
	@RequestMapping(value = "/BibliotecaRest/Turni/Cancella", method = RequestMethod.DELETE, consumes = "application/json")
	public void cancellaTurno(@RequestParam(value="idturno") int id) {
		ts.cancellaTurni(id);
	}
	
	@RequestMapping(value = "/BibliotecaRest/Turni/Modifica", method = RequestMethod.PUT, consumes = "application/json")
	public void modificaTurno(@RequestParam(value="idturno") int id, @RequestParam(value="matricola") int matricola, @RequestParam(value="data_inizio") String data_inizio, @RequestParam(value="data_fine") String data_fine ) {
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
	}
	
}
