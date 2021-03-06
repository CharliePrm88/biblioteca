
package TEST;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ContoCorrenteCtr", targetNamespace = "http://ctr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ContoCorrenteCtr {


    /**
     * 
     * @param arg0
     * @return
     *     returns TEST.ResponseContoCorrente
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ritornaCC", targetNamespace = "http://ctr/", className = "TEST.RitornaCC")
    @ResponseWrapper(localName = "ritornaCCResponse", targetNamespace = "http://ctr/", className = "TEST.RitornaCCResponse")
    public ResponseContoCorrente ritornaCC(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns TEST.ResponseContoCorrente
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modificaCC", targetNamespace = "http://ctr/", className = "TEST.ModificaCC")
    @ResponseWrapper(localName = "modificaCCResponse", targetNamespace = "http://ctr/", className = "TEST.ModificaCCResponse")
    public ResponseContoCorrente modificaCC(
        @WebParam(name = "arg0", targetNamespace = "")
        ContoCorrente arg0);

    /**
     * 
     * @return
     *     returns TEST.ResponseContoCorrente
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ritornaListaCC", targetNamespace = "http://ctr/", className = "TEST.RitornaListaCC")
    @ResponseWrapper(localName = "ritornaListaCCResponse", targetNamespace = "http://ctr/", className = "TEST.RitornaListaCCResponse")
    public ResponseContoCorrente ritornaListaCC();

    /**
     * 
     * @param arg0
     * @return
     *     returns TEST.ResponseContoCorrente
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cancellaCC", targetNamespace = "http://ctr/", className = "TEST.CancellaCC")
    @ResponseWrapper(localName = "cancellaCCResponse", targetNamespace = "http://ctr/", className = "TEST.CancellaCCResponse")
    public ResponseContoCorrente cancellaCC(
        @WebParam(name = "arg0", targetNamespace = "")
        ContoCorrente arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns TEST.ResponseContoCorrente
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "inserisciCC", targetNamespace = "http://ctr/", className = "TEST.InserisciCC")
    @ResponseWrapper(localName = "inserisciCCResponse", targetNamespace = "http://ctr/", className = "TEST.InserisciCCResponse")
    public ResponseContoCorrente inserisciCC(
        @WebParam(name = "arg0", targetNamespace = "")
        ContoCorrente arg0);

}
