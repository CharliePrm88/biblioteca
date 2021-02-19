/**
 * TipoMovimentoCtr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package proxy;

public interface TipoMovimentoCtr extends java.rmi.Remote {
    public proxy.ResponseTipoMovimento modificaTM(proxy.TipoMovimento arg0) throws java.rmi.RemoteException;
    public proxy.ResponseTipoMovimento ritornaListaTM() throws java.rmi.RemoteException;
    public proxy.ResponseTipoMovimento inserisciTM(proxy.TipoMovimento arg0) throws java.rmi.RemoteException;
    public proxy.ResponseTipoMovimento cancellaTM(proxy.TipoMovimento arg0) throws java.rmi.RemoteException;
    public proxy.ResponseTipoMovimento ritornaTM(int arg0) throws java.rmi.RemoteException;
}
