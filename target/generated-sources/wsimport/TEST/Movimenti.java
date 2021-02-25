
package TEST;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per movimenti complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="movimenti">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data_movimento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="iban" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_tipo_movimento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="importo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "movimenti", propOrder = {
    "dataMovimento",
    "iban",
    "id",
    "idTipoMovimento",
    "importo"
})
public class Movimenti {

    @XmlElement(name = "data_movimento")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataMovimento;
    protected int iban;
    protected int id;
    @XmlElement(name = "id_tipo_movimento")
    protected int idTipoMovimento;
    protected float importo;

    /**
     * Recupera il valore della proprietà dataMovimento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataMovimento() {
        return dataMovimento;
    }

    /**
     * Imposta il valore della proprietà dataMovimento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataMovimento(XMLGregorianCalendar value) {
        this.dataMovimento = value;
    }

    /**
     * Recupera il valore della proprietà iban.
     * 
     */
    public int getIban() {
        return iban;
    }

    /**
     * Imposta il valore della proprietà iban.
     * 
     */
    public void setIban(int value) {
        this.iban = value;
    }

    /**
     * Recupera il valore della proprietà id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà idTipoMovimento.
     * 
     */
    public int getIdTipoMovimento() {
        return idTipoMovimento;
    }

    /**
     * Imposta il valore della proprietà idTipoMovimento.
     * 
     */
    public void setIdTipoMovimento(int value) {
        this.idTipoMovimento = value;
    }

    /**
     * Recupera il valore della proprietà importo.
     * 
     */
    public float getImporto() {
        return importo;
    }

    /**
     * Imposta il valore della proprietà importo.
     * 
     */
    public void setImporto(float value) {
        this.importo = value;
    }

}
