
package TEST;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per responseMovimenti complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="responseMovimenti">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ctr/}response">
 *       &lt;sequence>
 *         &lt;element name="l1" type="{http://ctr/}movimenti" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="m" type="{http://ctr/}movimenti" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseMovimenti", propOrder = {
    "l1",
    "m"
})
public class ResponseMovimenti
    extends Response
{

    @XmlElement(nillable = true)
    protected List<Movimenti> l1;
    protected Movimenti m;

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
     * {@link Movimenti }
     * 
     * 
     */
    public List<Movimenti> getL1() {
        if (l1 == null) {
            l1 = new ArrayList<Movimenti>();
        }
        return this.l1;
    }

    /**
     * Recupera il valore della proprietà m.
     * 
     * @return
     *     possible object is
     *     {@link Movimenti }
     *     
     */
    public Movimenti getM() {
        return m;
    }

    /**
     * Imposta il valore della proprietà m.
     * 
     * @param value
     *     allowed object is
     *     {@link Movimenti }
     *     
     */
    public void setM(Movimenti value) {
        this.m = value;
    }

}
