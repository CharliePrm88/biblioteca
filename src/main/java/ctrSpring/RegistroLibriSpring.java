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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.RegistroLibriDao;
import model.RegistroLibri;

@Controller
public class RegistroLibriSpring {
	RegistroLibriDao reg = new RegistroLibriDao();   
	@RequestMapping(value = "/Biblioteca/Registro/Lista", method = RequestMethod.GET)
	public String ListaRegistroLibri(ModelMap model) {
		List<RegistroLibri> l1 = ritornaListaRegistroLibri();
		model.addAttribute("ListaRegistroLibri",l1);
		return "/Biblioteca/Registro/ListaTuttiRegistri";

	}

	@RequestMapping(value = "/Biblioteca/Registro/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaRegistroLibrii(@RequestParam(value="idRegistro",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		RegistroLibri RegistroLibri = ritornaRegistroLibri(id);
		model.setViewName("Biblioteca/RegistroLibri/ritornaRegistroLibri");
		model.addObject("RegistroLibri", RegistroLibri);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Registro/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciRegistroLibri(int idCliente,int idLibro,int matricola, String data_prestito, String data_scadenza, String data_rientro) {
		ModelAndView model = new ModelAndView();
		model.setViewName("Inserimento");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data_prestito1 = null;
		java.util.Date data_scadenza1= null;
		java.util.Date data_rientro1= null;
		try {
			data_prestito1 = sdf.parse(data_prestito);
			data_scadenza1= sdf.parse(data_scadenza);
			data_rientro1= sdf.parse(data_rientro);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d1 = new Date(data_prestito1.getTime());
		java.sql.Date d2 = new Date(data_scadenza1.getTime());
		java.sql.Date d3 = new Date(data_rientro1.getTime());
		RegistroLibri registroLibri = new RegistroLibri(idLibro,idCliente,matricola,d1,d2,d3);
		inserisciregendente(registroLibri);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Registro/Cancella", method = RequestMethod.GET)
	public ModelAndView cancellaRegistroLibri(@RequestParam(value="matricola") int id) {
		ModelAndView model = new ModelAndView();
		RegistroLibri RegistroLibri = ritornaRegistroLibri(id);
		cancellaRegistroLibri(RegistroLibri);
		List<RegistroLibri> l1 = ritornaListaRegistroLibri();
		model.setViewName("/Biblioteca/RegistroLibri/ListaTuttiRegistri");
		model.addObject("ListaRegistroLibri",l1);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Registro/Modifica", method = RequestMethod.GET)
	public ModelAndView modificaRegistroLibri(@RequestParam(value="idRegistro") int idRegistro, @RequestParam(value="idLibro") int idlibro,  @RequestParam(value="idCliente") int idcliente, @RequestParam(value="matricola") int matricola, @RequestParam(value="data_prestito") String data_prestito, @RequestParam(value="data_scadenza") String data_scadenza, @RequestParam(value="data_rientro") String data_rientro) {
		ModelAndView model = new ModelAndView();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data_prestito1 = null;
		java.util.Date data_scadenza1= null;
		java.util.Date data_rientro1= null;
		try {
			data_prestito1 = sdf.parse(data_prestito);
			data_scadenza1= sdf.parse(data_scadenza);
			data_rientro1= sdf.parse(data_rientro);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date d1 = new Date(data_prestito1.getTime());
		java.sql.Date d2 = new Date(data_scadenza1.getTime());
		java.sql.Date d3 = new Date(data_rientro1.getTime());
		RegistroLibri RegistroLibri = new RegistroLibri(idRegistro,idlibro,idcliente,matricola,d1,d2,d3);
		aggiornaRegistroLibri(RegistroLibri);
		List<RegistroLibri> l1 = ritornaListaRegistroLibri();
		model.setViewName("/Biblioteca/Registro/ListaTuttiRegistroLibri");
		model.addObject("ListaRegistroLibri",l1);
		return model;
	}
	
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
