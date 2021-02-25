
package TEST;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per contoCorrente complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="contoCorrente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data_creazione" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="iban" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="saldo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contoCorrente", propOrder = {
    "dataCreazione",
    "iban",
    "idCliente",
    "saldo"
})
public class ContoCorrente {

    @XmlElement(name = "data_creazione")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataCreazione;
    protected int iban;
    protected int idCliente;
    protected float saldo;

    /**
     * Recupera il valore della proprietà dataCreazione.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataCreazione() {
        return dataCreazione;
    }

    /**
     * Imposta il valore della proprietà dataCreazione.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataCreazione(XMLGregorianCalendar value) {
        this.dataCreazione = value;
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
     * Recupera il valore della proprietà idCliente.
     * 
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Imposta il valore della proprietà idCliente.
     * 
     */
    public void setIdCliente(int value) {
        this.idCliente = value;
    }

    /**
     * Recupera il valore della proprietà saldo.
     * 
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Imposta il valore della proprietà saldo.
     * 
     */
    public void setSaldo(float value) {
        this.saldo = value;
    }

}
