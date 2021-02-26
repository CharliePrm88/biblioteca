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

import entity.Registrolibri;
import service.ClientiService;
import service.DipendentiService;
import service.LibriService;
import service.RegistroLibriService;

@Controller
public class RegistroLibriSpring {
	private LibriService ls;
	private DipendentiService ds;
	private ClientiService cs;
	@Autowired
	private RegistroLibriService rls;
	
	@RequestMapping(value = "/Biblioteca/Registro/Lista", method = RequestMethod.GET)
	public String ListaRegistroLibri(ModelMap model) {
		List<Registrolibri> l1 = rls.ritornaListaRegistrolibri();
		model.addAttribute("ListaRegistroLibri",l1);
		return "/Biblioteca/Registro/ListaTuttiRegistri";

	}

	@RequestMapping(value = "/Biblioteca/Registro/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaRegistroLibrii(@RequestParam(value="idRegistro",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		Registrolibri RegistroLibri = rls.ritornaRegistrolibri(id);
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
		Registrolibri registroLibri = new Registrolibri(d1,d3,d2,cs.ritornaClienti(idCliente),ds.ritornaDipendenti(matricola),ls.ritornaLibri(idLibro));
		rls.inserisciRegistrolibri(registroLibri);
		return model;
	}
	
	@RequestMapping(value = "/Biblioteca/Registro/Cancella", method = RequestMethod.GET)
	public ModelAndView cancellaRegistroLibri(@RequestParam(value="matricola") int id) {
		ModelAndView model = new ModelAndView();
		rls.cancellaRegistrolibri(id);
		List<Registrolibri> l1 = rls.ritornaListaRegistrolibri();
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
		Registrolibri RegistroLibri = new Registrolibri(idRegistro,d1,d3,d2,cs.ritornaClienti(idcliente),ds.ritornaDipendenti(matricola),ls.ritornaLibri(idlibro));
		rls.aggiornaRegistrolibri(RegistroLibri);
		List<Registrolibri> l1 = rls.ritornaListaRegistrolibri();
		model.setViewName("/Biblioteca/Registro/ListaTuttiRegistroLibri");
		model.addObject("ListaRegistroLibri",l1);
		return model;
	}
	
}
