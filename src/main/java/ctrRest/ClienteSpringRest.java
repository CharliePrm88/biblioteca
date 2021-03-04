package ctrRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.ClientiService;
import entity.Clienti;
@RestController
@CrossOrigin
public class ClienteSpringRest {
	
	@Autowired
	private ClientiService cs;


	@RequestMapping(value = "/BibliotecaRest/Cliente/Lista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Clienti> ListaClienti() {
		List<Clienti> l1 = cs.ritornaListaClienti();
		return l1;
	}
	
	@RequestMapping(value = "/BibliotecaRest/Cliente/Ritorna", method = RequestMethod.GET, produces = "application/json")
	public Clienti ritornaCliente(@RequestParam(value="idCliente",required = true,defaultValue ="0") int id) {
		Clienti Cliente = cs.ritornaClienti(id);
		return Cliente;
	}
	
	@RequestMapping(value = "/BibliotecaRest/Cliente/Inserisci", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void inserisciClienti(@RequestBody Clienti c) {
		cs.inserisciClienti(c);
	}
	
	@RequestMapping(value = "/BibliotecaRest/Cliente/Cancella", method = RequestMethod.DELETE, consumes = "application/json")
	public void cancellaCliente(@RequestParam(value="idCliente") int id) {
		cs.cancellaClienti(id);
	}
	
	@RequestMapping(value = "/BibliotecaRest/Cliente/Modifica", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseBody
	public void modificaCliente(@RequestBody Clienti c) {
		cs.aggiornaClienti(c);
	}

}
