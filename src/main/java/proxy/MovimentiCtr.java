/**
 * MovimentiCtr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public interface MovimentiCtr extends java.rmi.Remote {
    public proxy.ResponseMovimenti ritornaM(int arg0) throws java.rmi.RemoteException;
    public proxy.ResponseMovimenti inserisciM(proxy.Movimenti arg0) throws java.rmi.RemoteException;
    public proxy.ResponseMovimenti modificaM(proxy.Movimenti arg0) throws java.rmi.RemoteException;
    public proxy.ResponseMovimenti cancellaM(proxy.Movimenti arg0) throws java.rmi.RemoteException;
    public proxy.ResponseMovimenti ritornaListaM() throws java.rmi.RemoteException;
}
