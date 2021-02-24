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

import proxy.ContoCorrente;
import proxy.ContoCorrenteCtrProxy;
import proxy.ResponseContoCorrente;

@Controller
public class ContoCorrenteCtrSoap {
	private ContoCorrenteCtrProxy cccp = new ContoCorrenteCtrProxy();   
	private ContoCorrente cc = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date cal = null;
	
	@RequestMapping(value = "/Banca/ContoCorrente/Lista", method = RequestMethod.GET)
	public String ListaContoCorrente(ModelMap model) {
		ResponseContoCorrente l1;
		try {
			l1 = cccp.ritornaListaCC();
			ContoCorrente[] cc2 = l1.getL1();
			model.addAttribute("listaCC", cc2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Banca/ContoCorrente/ListaTuttiCC";
	}
	
	@RequestMapping(value = "/Banca/ContoCorrente/Ritorna", method = RequestMethod.GET)
	public ModelAndView ritornaCC(@RequestParam(value="idCliente",required = true,defaultValue ="0") int id) {
		ModelAndView model = new ModelAndView();
		ResponseContoCorrente cc1;
		try {
			cc1 = cccp.ritornaCC(id);
			ContoCorrente l2= cc1.getCc();
			model.setViewName("Banca/ContoCorrente/ritornaCC");
			model.addObject("CC", l2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/Banca/ContoCorrente/Inserisci", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView inserisciContoCorrente(String data_creazione,int iban,int idCliente,float saldo) {
		ModelAndView model = new ModelAndView();
		try {
			cal = sdf.parse(data_creazione);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cc = new ContoCorrente(cal,iban,idCliente,saldo);
		try {
			cccp.inserisciCC(cc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("Inserimento");
		return model;
	}
	
	@RequestMapping(value = "/Banca/ContoCorrente/Cancella", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView cancellaCliente(String data_creazione,int iban,int idCliente,float saldo) {
		ModelAndView model = new ModelAndView();
		try {
			cal=sdf.parse(data_creazione);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cc = new ContoCorrente(cal,iban,idCliente,saldo);
			cccp.cancellaCC(cc);
			ResponseContoCorrente l4 = cccp.ritornaListaCC();
			ContoCorrente[] cc4 = l4.getL1();
			model.addObject("listaCC", cc4);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("/Banca/ContoCorrente/ListaTuttiCC");
		return model;
	}
	
	@RequestMapping(value = "/Banca/ContoCorrente/Modifica", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView modificaCliente(String data_creazione,int iban,int idCliente,float saldo) {
		ModelAndView model = new ModelAndView();
		try {
			cal=sdf.parse(data_creazione);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cc = new ContoCorrente(cal,iban,idCliente,saldo);
			cccp.modificaCC(cc);
			ResponseContoCorrente l3 = cccp.ritornaListaCC();
			ContoCorrente[] cc3 = l3.getL1();
			model.addObject("listaCC",cc3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setViewName("/Banca/ContoCorrente/ListaTuttiCC");
		return model;
	}
}
