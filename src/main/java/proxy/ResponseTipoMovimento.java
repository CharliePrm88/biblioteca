/**
 * ResponseTipoMovimento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public class ResponseTipoMovimento  extends proxy.Response  implements java.io.Serializable {
    private proxy.TipoMovimento[] l1;

    private proxy.TipoMovimento tm;

    public ResponseTipoMovimento() {
    }

    public ResponseTipoMovimento(
           java.lang.String description,
           int errorCode,
           java.lang.String result,
           proxy.TipoMovimento[] l1,
           proxy.TipoMovimento tm) {
        super(
            description,
            errorCode,
            result);
        this.l1 = l1;
        this.tm = tm;
    }


    /**
     * Gets the l1 value for this ResponseTipoMovimento.
     * 
     * @return l1
     */
    public proxy.TipoMovimento[] getL1() {
        return l1;
    }


    /**
     * Sets the l1 value for this ResponseTipoMovimento.
     * 
     * @param l1
     */
    public void setL1(proxy.TipoMovimento[] l1) {
        this.l1 = l1;
    }

    public proxy.TipoMovimento getL1(int i) {
        return this.l1[i];
    }

    public void setL1(int i, proxy.TipoMovimento _value) {
        this.l1[i] = _value;
    }


    /**
     * Gets the tm value for this ResponseTipoMovimento.
     * 
     * @return tm
     */
    public proxy.TipoMovimento getTm() {
        return tm;
    }


    /**
     * Sets the tm value for this ResponseTipoMovimento.
     * 
     * @param tm
     */
    public void setTm(proxy.TipoMovimento tm) {
        this.tm = tm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseTipoMovimento)) return false;
        ResponseTipoMovimento other = (ResponseTipoMovimento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.l1==null && other.getL1()==null) || 
             (this.l1!=null &&
              java.util.Arrays.equals(this.l1, other.getL1()))) &&
            ((this.tm==null && other.getTm()==null) || 
             (this.tm!=null &&
              this.tm.equals(other.getTm())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getL1() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getL1());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getL1(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTm() != null) {
            _hashCode += getTm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseTipoMovimento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ctr/", "responseTipoMovimento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("l1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "l1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ctr/", "tipoMovimento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ctr/", "tipoMovimento"));
        elemField.setMinOccurs(0);
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
