/**
 * Movimenti.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public class Movimenti  implements java.io.Serializable {
    private java.util.Date data_movimento;

    private int iban;

    private int id;

    private int id_tipo_movimento;

    private float importo;

    public Movimenti() {
    }

    public Movimenti(
           java.util.Date data_movimento,
           int iban,
           int id,
           int id_tipo_movimento,
           float importo) {
           this.data_movimento = data_movimento;
           this.iban = iban;
           this.id = id;
           this.id_tipo_movimento = id_tipo_movimento;
           this.importo = importo;
    }


    /**
     * Gets the data_movimento value for this Movimenti.
     * 
     * @return data_movimento
     */
    public java.util.Date getData_movimento() {
        return data_movimento;
    }


    /**
     * Sets the data_movimento value for this Movimenti.
     * 
     * @param data_movimento
     */
    public void setData_movimento(java.util.Date data_movimento) {
        this.data_movimento = data_movimento;
    }


    /**
     * Gets the iban value for this Movimenti.
     * 
     * @return iban
     */
    public int getIban() {
        return iban;
    }


    /**
     * Sets the iban value for this Movimenti.
     * 
     * @param iban
     */
    public void setIban(int iban) {
        this.iban = iban;
    }


    /**
     * Gets the id value for this Movimenti.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Movimenti.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the id_tipo_movimento value for this Movimenti.
     * 
     * @return id_tipo_movimento
     */
    public int getId_tipo_movimento() {
        return id_tipo_movimento;
    }


    /**
     * Sets the id_tipo_movimento value for this Movimenti.
     * 
     * @param id_tipo_movimento
     */
    public void setId_tipo_movimento(int id_tipo_movimento) {
        this.id_tipo_movimento = id_tipo_movimento;
    }


    /**
     * Gets the importo value for this Movimenti.
     * 
     * @return importo
     */
    public float getImporto() {
        return importo;
    }


    /**
     * Sets the importo value for this Movimenti.
     * 
     * @param importo
     */
    public void setImporto(float importo) {
        this.importo = importo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Movimenti)) return false;
        Movimenti other = (Movimenti) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.data_movimento==null && other.getData_movimento()==null) || 
             (this.data_movimento!=null &&
              this.data_movimento.equals(other.getData_movimento()))) &&
            this.iban == other.getIban() &&
            this.id == other.getId() &&
            this.id_tipo_movimento == other.getId_tipo_movimento() &&
            this.importo == other.getImporto();
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
        if (getData_movimento() != null) {
            _hashCode += getData_movimento().hashCode();
        }
        _hashCode += getIban();
        _hashCode += getId();
        _hashCode += getId_tipo_movimento();
        _hashCode += new Float(getImporto()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Movimenti.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ctr/", "movimenti"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data_movimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data_movimento"));
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
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_tipo_movimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id_tipo_movimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importo"));
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
