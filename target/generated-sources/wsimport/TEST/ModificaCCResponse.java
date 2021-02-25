
package TEST;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per modificaCCResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="modificaCCResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ctr/}responseContoCorrente" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modificaCCResponse", propOrder = {
    "_return"
})
public class ModificaCCResponse {

    @XmlElement(name = "return")
    protected ResponseContoCorrente _return;

    /**
     * Recupera il valore della propriet� return.
     * 
     * @return
     *     possible object is
     *     {@link ResponseContoCorrente }
     *     
     */
    public ResponseContoCorrente getReturn() {
        return _return;
    }

    /**
     * Imposta il valore della propriet� return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseContoCorrente }
     *     
     */
    public void setReturn(ResponseContoCorrente value) {
        this._return = value;
    }

}
