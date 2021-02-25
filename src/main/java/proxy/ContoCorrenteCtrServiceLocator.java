/**
 * ContoCorrenteCtrServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public class ContoCorrenteCtrServiceLocator extends org.apache.axis.client.Service implements proxy.ContoCorrenteCtrService {

    public ContoCorrenteCtrServiceLocator() {
    }


    public ContoCorrenteCtrServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ContoCorrenteCtrServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ContoCorrenteCtrPort
    private java.lang.String ContoCorrenteCtrPort_address = "http://localhost:8080/ewalletMaven-0.0.1-SNAPSHOT/ContoCorrenteCtr";

    public java.lang.String getContoCorrenteCtrPortAddress() {
        return ContoCorrenteCtrPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ContoCorrenteCtrPortWSDDServiceName = "ContoCorrenteCtrPort";

    public java.lang.String getContoCorrenteCtrPortWSDDServiceName() {
        return ContoCorrenteCtrPortWSDDServiceName;
    }

    public void setContoCorrenteCtrPortWSDDServiceName(java.lang.String name) {
        ContoCorrenteCtrPortWSDDServiceName = name;
    }

    public proxy.ContoCorrenteCtr getContoCorrenteCtrPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ContoCorrenteCtrPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getContoCorrenteCtrPort(endpoint);
    }

    public proxy.ContoCorrenteCtr getContoCorrenteCtrPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            proxy.ContoCorrenteCtrServiceSoapBindingStub _stub = new proxy.ContoCorrenteCtrServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getContoCorrenteCtrPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setContoCorrenteCtrPortEndpointAddress(java.lang.String address) {
        ContoCorrenteCtrPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (proxy.ContoCorrenteCtr.class.isAssignableFrom(serviceEndpointInterface)) {
                proxy.ContoCorrenteCtrServiceSoapBindingStub _stub = new proxy.ContoCorrenteCtrServiceSoapBindingStub(new java.net.URL(ContoCorrenteCtrPort_address), this);
                _stub.setPortName(getContoCorrenteCtrPortWSDDServiceName());
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
        if ("ContoCorrenteCtrPort".equals(inputPortName)) {
            return getContoCorrenteCtrPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ctr/", "ContoCorrenteCtrService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ctr/", "ContoCorrenteCtrPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ContoCorrenteCtrPort".equals(portName)) {
            setContoCorrenteCtrPortEndpointAddress(address);
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
