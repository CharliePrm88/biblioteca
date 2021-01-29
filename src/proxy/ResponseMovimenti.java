/**
 * ResponseMovimenti.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public class ResponseMovimenti  extends proxy.Response  implements java.io.Serializable {
    private proxy.Movimenti[] l1;

    private proxy.Movimenti m;

    public ResponseMovimenti() {
    }

    public ResponseMovimenti(
           java.lang.String description,
           int errorCode,
           java.lang.String result,
           proxy.Movimenti[] l1,
           proxy.Movimenti m) {
        super(
            description,
            errorCode,
            result);
        this.l1 = l1;
        this.m = m;
    }


    /**
     * Gets the l1 value for this ResponseMovimenti.
     * 
     * @return l1
     */
    public proxy.Movimenti[] getL1() {
        return l1;
    }


    /**
     * Sets the l1 value for this ResponseMovimenti.
     * 
     * @param l1
     */
    public void setL1(proxy.Movimenti[] l1) {
        this.l1 = l1;
    }

    public proxy.Movimenti getL1(int i) {
        return this.l1[i];
    }

    public void setL1(int i, proxy.Movimenti _value) {
        this.l1[i] = _value;
    }


    /**
     * Gets the m value for this ResponseMovimenti.
     * 
     * @return m
     */
    public proxy.Movimenti getM() {
        return m;
    }


    /**
     * Sets the m value for this ResponseMovimenti.
     * 
     * @param m
     */
    public void setM(proxy.Movimenti m) {
        this.m = m;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseMovimenti)) return false;
        ResponseMovimenti other = (ResponseMovimenti) obj;
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
            ((this.m==null && other.getM()==null) || 
             (this.m!=null &&
              this.m.equals(other.getM())));
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
        if (getM() != null) {
            _hashCode += getM().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseMovimenti.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ctr/", "responseMovimenti"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("l1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "l1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ctr/", "movimenti"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ctr/", "movimenti"));
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
