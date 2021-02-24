package ctrBancaSpring;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import proxy.Movimenti;
import proxy.MovimentiCtrProxy;
import proxy.ResponseMovimenti;

@Controller
public class MovimentiCtrSoap {
	private MovimentiCtrProxy Mcp = new MovimentiCtrProxy();
	private Movimenti M = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date cal = null;
	
	@RequestMapping(value = "/Banca/Movimento/Lista", method = RequestMethod.GET)
	public String ListaMovimenti(ModelMap model) {
		try {
			ResponseMovimenti l1 = Mcp.ritornaListaM();
			Movimenti[] M2 = l1.getL1();
			model.addAttribute("listaM", M2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Banca/Movimento/ListaTuttiM";
	}
	
	@RequestMapping(value = "/Banca/Movimento/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaMovimento(@RequestParam(value="idCliente",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		try {
			ResponseMovimenti M1=Mcp.ritornaM(id);
			Movimenti l2= M1.getM();
			model.setViewName("Banca/Movimento/ritornaM");
			model.addObject("CC", l2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/Banca/Movimento/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciMovimento(String data_movimento,int iban,int id,int idTipoMovimento,float importo) {
		ModelAndView model = new ModelAndView();
		try {
			cal = sdf.parse(data_movimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			M = new Movimenti(cal,iban,id,idTipoMovimento,importo);
			Mcp.inserisciM(M);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("Inserimento");
		return model;
	}
	@RequestMapping(value = "/Banca/Movimento/Cancella", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cancellaMovimento(String data_movimento,int iban,int id,int idTipoMovimento,float importo) {
		ModelAndView model = new ModelAndView();
		try {
			cal=sdf.parse(data_movimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			M = new Movimenti(cal,iban,id,idTipoMovimento,importo);
			Mcp.cancellaM(M);
			ResponseMovimenti l4 = Mcp.ritornaListaM();
			Movimenti[] M4 = l4.getL1();
			model.addObject("listaM", M4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("/Banca/Movimento/ListaTuttiM");
		return model;
	}
	
	@RequestMapping(value = "/Banca/Movimento/Modifica", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView modificaMovimento(String data_movimento,int iban,int id,int idTipoMovimento,float importo) {
		ModelAndView model = new ModelAndView();
		try {
			cal=sdf.parse(data_movimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			M = new Movimenti(cal,iban,id,idTipoMovimento,importo);
			Mcp.modificaM(M);
			ResponseMovimenti l3 = Mcp.ritornaListaM();
			Movimenti[] M3 = l3.getL1();
			model.addObject("listaM",M3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("/Banca/Movimento/ListaTuttiM");
		return model;
	}
}
