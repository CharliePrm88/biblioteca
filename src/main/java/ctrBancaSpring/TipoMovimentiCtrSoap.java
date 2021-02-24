package ctrBancaSpring;

import java.rmi.RemoteException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import proxy.ResponseTipoMovimento;
import proxy.TipoMovimento;
import proxy.TipoMovimentoCtrProxy;

@Controller
public class TipoMovimentiCtrSoap {
    private TipoMovimentoCtrProxy Mcp = new TipoMovimentoCtrProxy();   
    private TipoMovimento M = null;
    
    @RequestMapping(value = "/Banca/TipoMovimento/Lista", method = RequestMethod.GET)
	public String ListaTipoMovimento(ModelMap model) {
		try {
			ResponseTipoMovimento l1 = Mcp.ritornaListaTM();
			TipoMovimento[] M2 = l1.getL1();
			model.addAttribute("listaTM", M2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Banca/ContoCorrente/ListaTuttiTM";
	}
	
	@RequestMapping(value = "/Banca/TipoMovimento/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaTipoMovimento(@RequestParam(value="id",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		try {
			ResponseTipoMovimento M1=Mcp.ritornaTM(id);
			TipoMovimento l2= M1.getTm();
			model.setViewName("Banca/TipoMovimento/ritornaTM");
			model.addObject("TM", l2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/Banca/TipoMovimento/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciTipoMovimento(String descrizione,int idTipoMovimento) {
		ModelAndView model = new ModelAndView();
		M = new TipoMovimento(descrizione,idTipoMovimento);
		try {
			Mcp.inserisciTM(M);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("Inserimento");
		return model;
	}
	
	@RequestMapping(value = "/Banca/TipoMovimento/Cancella", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cancellaTipoMovimento(String descrizione,int idTipoMovimento) {
		ModelAndView model = new ModelAndView();
		try {
			M = new TipoMovimento(descrizione,idTipoMovimento);
			Mcp.cancellaTM(M);
			ResponseTipoMovimento l4 = Mcp.ritornaListaTM();
			TipoMovimento[] M4 = l4.getL1();
			model.addObject("listaTM", M4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("/Banca/TipoMovimento/ListaTuttiTM");
		return model;
	}
	
	@RequestMapping(value = "/Banca/TipoMovimento/Modifica", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView modificaTipoMovimento(String descrizione,int idTipoMovimento) {
		ModelAndView model = new ModelAndView();
		try {
			M = new TipoMovimento(descrizione,idTipoMovimento);
			Mcp.modificaTM(M);
			ResponseTipoMovimento l3 = Mcp.ritornaListaTM();
			TipoMovimento[] M3 = l3.getL1();
			model.addObject("listaTM",M3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("/Banca/TipoMovimento/ListaTuttiTM");
		return model;
	}
}
