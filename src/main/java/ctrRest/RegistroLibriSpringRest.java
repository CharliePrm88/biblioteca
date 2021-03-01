package ctrRest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Registrolibri;
import service.ClientiService;
import service.DipendentiService;
import service.LibriService;
import service.RegistroLibriService;

@RestController
public class RegistroLibriSpringRest {
	private LibriService ls;
	private DipendentiService ds;
	private ClientiService cs;
	@Autowired
	private RegistroLibriService rls;
	
	@RequestMapping(value = "/BibliotecaRest/Registro/Lista", method = RequestMethod.GET, produces = "application/json")
	public List<Registrolibri> ListaRegistroLibri(ModelMap model) {
		List<Registrolibri> l1 = rls.ritornaListaRegistrolibri();
		return l1;

	}

	@RequestMapping(value = "/BibliotecaRest/Registro/Ritorna", method = RequestMethod.GET, produces = "application/json")
	public Registrolibri ritornaRegistroLibrii(@RequestParam(value="idRegistro",required = true,defaultValue ="0") int id) {
		Registrolibri RegistroLibri = rls.ritornaRegistrolibri(id);
		return RegistroLibri;
	}
	
	@RequestMapping(value = "/BibliotecaRest/Registro/Inserisci", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void inserisciRegistroLibri(int idCliente,int idLibro,int matricola, String data_prestito, String data_scadenza, String data_rientro) {
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
	}
	
	@RequestMapping(value = "/BibliotecaRest/Registro/Cancella", method = RequestMethod.DELETE, consumes = "application/json")
	public void cancellaRegistroLibri(@RequestParam(value="matricola") int id) {
		rls.cancellaRegistrolibri(id);
	}
	
	@RequestMapping(value = "/BibliotecaRest/Registro/Modifica", method = RequestMethod.PUT, consumes = "application/json")
	public void modificaRegistroLibri(@RequestParam(value="idRegistro") int idRegistro, @RequestParam(value="idLibro") int idlibro,  @RequestParam(value="idCliente") int idcliente, @RequestParam(value="matricola") int matricola, @RequestParam(value="data_prestito") String data_prestito, @RequestParam(value="data_scadenza") String data_scadenza, @RequestParam(value="data_rientro") String data_rientro) {
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
	}
	
}
