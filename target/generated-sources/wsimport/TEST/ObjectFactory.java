
package TEST;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the TEST package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ModificaTM_QNAME = new QName("http://ctr/", "modificaTM");
    private final static QName _RitornaTMResponse_QNAME = new QName("http://ctr/", "ritornaTMResponse");
    private final static QName _RitornaListaTMResponse_QNAME = new QName("http://ctr/", "ritornaListaTMResponse");
    private final static QName _InserisciTMResponse_QNAME = new QName("http://ctr/", "inserisciTMResponse");
    private final static QName _RitornaListaTM_QNAME = new QName("http://ctr/", "ritornaListaTM");
    private final static QName _InserisciTM_QNAME = new QName("http://ctr/", "inserisciTM");
    private final static QName _CancellaTM_QNAME = new QName("http://ctr/", "cancellaTM");
    private final static QName _CancellaTMResponse_QNAME = new QName("http://ctr/", "cancellaTMResponse");
    private final static QName _ModificaTMResponse_QNAME = new QName("http://ctr/", "modificaTMResponse");
    private final static QName _RitornaTM_QNAME = new QName("http://ctr/", "ritornaTM");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: TEST
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InserisciTMResponse }
     * 
     */
    public InserisciTMResponse createInserisciTMResponse() {
        return new InserisciTMResponse();
    }

    /**
     * Create an instance of {@link RitornaListaTM }
     * 
     */
    public RitornaListaTM createRitornaListaTM() {
        return new RitornaListaTM();
    }

    /**
     * Create an instance of {@link InserisciTM }
     * 
     */
    public InserisciTM createInserisciTM() {
        return new InserisciTM();
    }

    /**
     * Create an instance of {@link CancellaTM }
     * 
     */
    public CancellaTM createCancellaTM() {
        return new CancellaTM();
    }

    /**
     * Create an instance of {@link CancellaTMResponse }
     * 
     */
    public CancellaTMResponse createCancellaTMResponse() {
        return new CancellaTMResponse();
    }

    /**
     * Create an instance of {@link ModificaTMResponse }
     * 
     */
    public ModificaTMResponse createModificaTMResponse() {
        return new ModificaTMResponse();
    }

    /**
     * Create an instance of {@link RitornaTM }
     * 
     */
    public RitornaTM createRitornaTM() {
        return new RitornaTM();
    }

    /**
     * Create an instance of {@link ModificaTM }
     * 
     */
    public ModificaTM createModificaTM() {
        return new ModificaTM();
    }

    /**
     * Create an instance of {@link RitornaTMResponse }
     * 
     */
    public RitornaTMResponse createRitornaTMResponse() {
        return new RitornaTMResponse();
    }

    /**
     * Create an instance of {@link RitornaListaTMResponse }
     * 
     */
    public RitornaListaTMResponse createRitornaListaTMResponse() {
        return new RitornaListaTMResponse();
    }

    /**
     * Create an instance of {@link ResponseTipoMovimento }
     * 
     */
    public ResponseTipoMovimento createResponseTipoMovimento() {
        return new ResponseTipoMovimento();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link TipoMovimento }
     * 
     */
    public TipoMovimento createTipoMovimento() {
        return new TipoMovimento();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificaTM }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "modificaTM")
    public JAXBElement<ModificaTM> createModificaTM(ModificaTM value) {
        return new JAXBElement<ModificaTM>(_ModificaTM_QNAME, ModificaTM.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RitornaTMResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "ritornaTMResponse")
    public JAXBElement<RitornaTMResponse> createRitornaTMResponse(RitornaTMResponse value) {
        return new JAXBElement<RitornaTMResponse>(_RitornaTMResponse_QNAME, RitornaTMResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RitornaListaTMResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "ritornaListaTMResponse")
    public JAXBElement<RitornaListaTMResponse> createRitornaListaTMResponse(RitornaListaTMResponse value) {
        return new JAXBElement<RitornaListaTMResponse>(_RitornaListaTMResponse_QNAME, RitornaListaTMResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InserisciTMResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "inserisciTMResponse")
    public JAXBElement<InserisciTMResponse> createInserisciTMResponse(InserisciTMResponse value) {
        return new JAXBElement<InserisciTMResponse>(_InserisciTMResponse_QNAME, InserisciTMResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RitornaListaTM }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "ritornaListaTM")
    public JAXBElement<RitornaListaTM> createRitornaListaTM(RitornaListaTM value) {
        return new JAXBElement<RitornaListaTM>(_RitornaListaTM_QNAME, RitornaListaTM.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InserisciTM }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "inserisciTM")
    public JAXBElement<InserisciTM> createInserisciTM(InserisciTM value) {
        return new JAXBElement<InserisciTM>(_InserisciTM_QNAME, InserisciTM.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancellaTM }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "cancellaTM")
    public JAXBElement<CancellaTM> createCancellaTM(CancellaTM value) {
        return new JAXBElement<CancellaTM>(_CancellaTM_QNAME, CancellaTM.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancellaTMResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "cancellaTMResponse")
    public JAXBElement<CancellaTMResponse> createCancellaTMResponse(CancellaTMResponse value) {
        return new JAXBElement<CancellaTMResponse>(_CancellaTMResponse_QNAME, CancellaTMResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificaTMResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "modificaTMResponse")
    public JAXBElement<ModificaTMResponse> createModificaTMResponse(ModificaTMResponse value) {
        return new JAXBElement<ModificaTMResponse>(_ModificaTMResponse_QNAME, ModificaTMResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RitornaTM }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ctr/", name = "ritornaTM")
    public JAXBElement<RitornaTM> createRitornaTM(RitornaTM value) {
        return new JAXBElement<RitornaTM>(_RitornaTM_QNAME, RitornaTM.class, null, value);
    }

}
