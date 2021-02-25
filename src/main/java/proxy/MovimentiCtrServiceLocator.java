/**
 * MovimentiCtrServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public class MovimentiCtrServiceLocator extends org.apache.axis.client.Service implements proxy.MovimentiCtrService {

    public MovimentiCtrServiceLocator() {
    }


    public MovimentiCtrServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MovimentiCtrServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MovimentiCtrPort
    private java.lang.String MovimentiCtrPort_address = "http://localhost:8080/ewalletMaven-0.0.1-SNAPSHOT/MovimentiCtr";

    public java.lang.String getMovimentiCtrPortAddress() {
        return MovimentiCtrPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MovimentiCtrPortWSDDServiceName = "MovimentiCtrPort";

    public java.lang.String getMovimentiCtrPortWSDDServiceName() {
        return MovimentiCtrPortWSDDServiceName;
    }

    public void setMovimentiCtrPortWSDDServiceName(java.lang.String name) {
        MovimentiCtrPortWSDDServiceName = name;
    }

    public proxy.MovimentiCtr getMovimentiCtrPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MovimentiCtrPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMovimentiCtrPort(endpoint);
    }

    public proxy.MovimentiCtr getMovimentiCtrPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            proxy.MovimentiCtrServiceSoapBindingStub _stub = new proxy.MovimentiCtrServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getMovimentiCtrPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMovimentiCtrPortEndpointAddress(java.lang.String address) {
        MovimentiCtrPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (proxy.MovimentiCtr.class.isAssignableFrom(serviceEndpointInterface)) {
                proxy.MovimentiCtrServiceSoapBindingStub _stub = new proxy.MovimentiCtrServiceSoapBindingStub(new java.net.URL(MovimentiCtrPort_address), this);
                _stub.setPortName(getMovimentiCtrPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MovimentiCtrPort".equals(inputPortName)) {
            return getMovimentiCtrPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ctr/", "MovimentiCtrService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ctr/", "MovimentiCtrPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MovimentiCtrPort".equals(portName)) {
            setMovimentiCtrPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
