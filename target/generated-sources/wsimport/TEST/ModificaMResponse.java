
package TEST;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per modificaMResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="modificaMResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ctr/}responseMovimenti" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modificaMResponse", propOrder = {
    "_return"
})
public class ModificaMResponse {

    @XmlElement(name = "return")
    protected ResponseMovimenti _return;

    /**
     * Recupera il valore della proprietÓ return.
     * 
     * @return
     *     possible object is
     *     {@link ResponseMovimenti }
     *     
     */
    public ResponseMovimenti getReturn() {
        return _return;
    }

    /**
     * Imposta il valore della proprietÓ return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseMovimenti }
     *     
     */
    public void setReturn(ResponseMovimenti value) {
        this._return = value;
    }

}
