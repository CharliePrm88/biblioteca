/**
 * ContoCorrenteCtr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public interface ContoCorrenteCtr extends java.rmi.Remote {
    public proxy.ResponseContoCorrente ritornaCC(int arg0) throws java.rmi.RemoteException;
    public proxy.ResponseContoCorrente modificaCC(proxy.ContoCorrente arg0) throws java.rmi.RemoteException;
    public proxy.ResponseContoCorrente ritornaListaCC() throws java.rmi.RemoteException;
    public proxy.ResponseContoCorrente cancellaCC(proxy.ContoCorrente arg0) throws java.rmi.RemoteException;
    public proxy.ResponseContoCorrente inserisciCC(proxy.ContoCorrente arg0) throws java.rmi.RemoteException;
}
