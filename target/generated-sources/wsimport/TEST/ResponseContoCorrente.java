
package TEST;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per responseContoCorrente complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="responseContoCorrente">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ctr/}response">
 *       &lt;sequence>
 *         &lt;element name="cc" type="{http://ctr/}contoCorrente" minOccurs="0"/>
 *         &lt;element name="l1" type="{http://ctr/}contoCorrente" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseContoCorrente", propOrder = {
    "cc",
    "l1"
})
public class ResponseContoCorrente
    extends Response
{

    protected ContoCorrente cc;
    @XmlElement(nillable = true)
    protected List<ContoCorrente> l1;

    /**
     * Recupera il valore della proprietà cc.
     * 
     * @return
     *     possible object is
     *     {@link ContoCorrente }
     *     
     */
    public ContoCorrente getCc() {
        return cc;
    }

    /**
     * Imposta il valore della proprietà cc.
     * 
     * @param value
     *     allowed object is
     *     {@link ContoCorrente }
     *     
     */
    public void setCc(ContoCorrente value) {
        this.cc = value;
    }

    /**
     * Gets the value of the l1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the l1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getL1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContoCorrente }
     * 
     * 
     */
    public List<ContoCorrente> getL1() {
        if (l1 == null) {
            l1 = new ArrayList<ContoCorrente>();
        }
        return this.l1;
    }

}
