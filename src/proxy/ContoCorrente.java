/**
 * ContoCorrente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public class ContoCorrente  implements java.io.Serializable {
    private java.util.Calendar data_creazione;

    private int iban;

    private int idCliente;

    private float saldo;

    public ContoCorrente() {
    }

    public ContoCorrente(
           java.util.Calendar data_creazione,
           int iban,
           int idCliente,
           float saldo) {
           this.data_creazione = data_creazione;
           this.iban = iban;
           this.idCliente = idCliente;
           this.saldo = saldo;
    }


    /**
     * Gets the data_creazione value for this ContoCorrente.
     * 
     * @return data_creazione
     */
    public java.util.Calendar getData_creazione() {
        return data_creazione;
    }


    /**
     * Sets the data_creazione value for this ContoCorrente.
     * 
     * @param data_creazione
     */
    public void setData_creazione(java.util.Calendar data_creazione) {
        this.data_creazione = data_creazione;
    }


    /**
     * Gets the iban value for this ContoCorrente.
     * 
     * @return iban
     */
    public int getIban() {
        return iban;
    }


    /**
     * Sets the iban value for this ContoCorrente.
     * 
     * @param iban
     */
    public void setIban(int iban) {
        this.iban = iban;
    }


    /**
     * Gets the idCliente value for this ContoCorrente.
     * 
     * @return idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }


    /**
     * Sets the idCliente value for this ContoCorrente.
     * 
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    /**
     * Gets the saldo value for this ContoCorrente.
     * 
     * @return saldo
     */
    public float getSaldo() {
        return saldo;
    }


    /**
     * Sets the saldo value for this ContoCorrente.
     * 
     * @param saldo
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ContoCorrente)) return false;
        ContoCorrente other = (ContoCorrente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.data_creazione==null && other.getData_creazione()==null) || 
             (this.data_creazione!=null &&
              this.data_creazione.equals(other.getData_creazione()))) &&
            this.iban == other.getIban() &&
            this.idCliente == other.getIdCliente() &&
            this.saldo == other.getSaldo();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getData_creazione() != null) {
            _hashCode += getData_creazione().hashCode();
        }
        _hashCode += getIban();
        _hashCode += getIdCliente();
        _hashCode += new Float(getSaldo()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ContoCorrente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ctr/", "contoCorrente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data_creazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data_creazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iban"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
