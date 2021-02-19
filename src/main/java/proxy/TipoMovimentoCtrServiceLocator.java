/**
 * TipoMovimentoCtrServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public class TipoMovimentoCtrServiceLocator extends org.apache.axis.client.Service implements proxy.TipoMovimentoCtrService {

    public TipoMovimentoCtrServiceLocator() {
    }


    public TipoMovimentoCtrServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TipoMovimentoCtrServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TipoMovimentoCtrPort
    private java.lang.String TipoMovimentoCtrPort_address = "http://localhost:8080/ewallet/TipoMovimentoCtr";

    public java.lang.String getTipoMovimentoCtrPortAddress() {
        return TipoMovimentoCtrPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TipoMovimentoCtrPortWSDDServiceName = "TipoMovimentoCtrPort";

    public java.lang.String getTipoMovimentoCtrPortWSDDServiceName() {
        return TipoMovimentoCtrPortWSDDServiceName;
    }

    public void setTipoMovimentoCtrPortWSDDServiceName(java.lang.String name) {
        TipoMovimentoCtrPortWSDDServiceName = name;
    }

    public proxy.TipoMovimentoCtr getTipoMovimentoCtrPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TipoMovimentoCtrPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTipoMovimentoCtrPort(endpoint);
    }

    public proxy.TipoMovimentoCtr getTipoMovimentoCtrPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            proxy.TipoMovimentoCtrServiceSoapBindingStub _stub = new proxy.TipoMovimentoCtrServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTipoMovimentoCtrPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTipoMovimentoCtrPortEndpointAddress(java.lang.String address) {
        TipoMovimentoCtrPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (proxy.TipoMovimentoCtr.class.isAssignableFrom(serviceEndpointInterface)) {
                proxy.TipoMovimentoCtrServiceSoapBindingStub _stub = new proxy.TipoMovimentoCtrServiceSoapBindingStub(new java.net.URL(TipoMovimentoCtrPort_address), this);
                _stub.setPortName(getTipoMovimentoCtrPortWSDDServiceName());
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
        if ("TipoMovimentoCtrPort".equals(inputPortName)) {
            return getTipoMovimentoCtrPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ctr/", "TipoMovimentoCtrService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ctr/", "TipoMovimentoCtrPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TipoMovimentoCtrPort".equals(portName)) {
            setTipoMovimentoCtrPortEndpointAddress(address);
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
