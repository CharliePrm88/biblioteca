
package TEST;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per responseTipoMovimento complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="responseTipoMovimento">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ctr/}response">
 *       &lt;sequence>
 *         &lt;element name="l1" type="{http://ctr/}tipoMovimento" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tm" type="{http://ctr/}tipoMovimento" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseTipoMovimento", propOrder = {
    "l1",
    "tm"
})
public class ResponseTipoMovimento
    extends Response
{

    @XmlElement(nillable = true)
    protected List<TipoMovimento> l1;
    protected TipoMovimento tm;

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
     * {@link TipoMovimento }
     * 
     * 
     */
    public List<TipoMovimento> getL1() {
        if (l1 == null) {
            l1 = new ArrayList<TipoMovimento>();
        }
        return this.l1;
    }

    /**
     * Recupera il valore della proprietà tm.
     * 
     * @return
     *     possible object is
     *     {@link TipoMovimento }
     *     
     */
    public TipoMovimento getTm() {
        return tm;
    }

    /**
     * Imposta il valore della proprietà tm.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoMovimento }
     *     
     */
    public void setTm(TipoMovimento value) {
        this.tm = value;
    }

}
