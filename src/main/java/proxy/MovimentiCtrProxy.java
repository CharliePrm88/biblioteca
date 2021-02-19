package proxy;

public class MovimentiCtrProxy implements proxy.MovimentiCtr {
  private String _endpoint = null;
  private proxy.MovimentiCtr movimentiCtr = null;
  
  public MovimentiCtrProxy() {
    _initMovimentiCtrProxy();
  }
  
  public MovimentiCtrProxy(String endpoint) {
    _endpoint = endpoint;
    _initMovimentiCtrProxy();
  }
  
  private void _initMovimentiCtrProxy() {
    try {
      movimentiCtr = (new proxy.MovimentiCtrServiceLocator()).getMovimentiCtrPort();
      if (movimentiCtr != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)movimentiCtr)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)movimentiCtr)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (movimentiCtr != null)
      ((javax.xml.rpc.Stub)movimentiCtr)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public proxy.MovimentiCtr getMovimentiCtr() {
    if (movimentiCtr == null)
      _initMovimentiCtrProxy();
    return movimentiCtr;
  }
  
  public proxy.ResponseMovimenti ritornaM(int arg0) throws java.rmi.RemoteException{
    if (movimentiCtr == null)
      _initMovimentiCtrProxy();
    return movimentiCtr.ritornaM(arg0);
  }
  
  public proxy.ResponseMovimenti inserisciM(proxy.Movimenti arg0) throws java.rmi.RemoteException{
    if (movimentiCtr == null)
      _initMovimentiCtrProxy();
    return movimentiCtr.inserisciM(arg0);
  }
  
  public proxy.ResponseMovimenti modificaM(proxy.Movimenti arg0) throws java.rmi.RemoteException{
    if (movimentiCtr == null)
      _initMovimentiCtrProxy();
    return movimentiCtr.modificaM(arg0);
  }
  
  public proxy.ResponseMovimenti cancellaM(proxy.Movimenti arg0) throws java.rmi.RemoteException{
    if (movimentiCtr == null)
      _initMovimentiCtrProxy();
    return movimentiCtr.cancellaM(arg0);
  }
  
  public proxy.ResponseMovimenti ritornaListaM() throws java.rmi.RemoteException{
    if (movimentiCtr == null)
      _initMovimentiCtrProxy();
    return movimentiCtr.ritornaListaM();
  }
  
  
}