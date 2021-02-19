package proxy;

public class TipoMovimentoCtrProxy implements proxy.TipoMovimentoCtr {
  private String _endpoint = null;
  private proxy.TipoMovimentoCtr tipoMovimentoCtr = null;
  
  public TipoMovimentoCtrProxy() {
    _initTipoMovimentoCtrProxy();
  }
  
  public TipoMovimentoCtrProxy(String endpoint) {
    _endpoint = endpoint;
    _initTipoMovimentoCtrProxy();
  }
  
  private void _initTipoMovimentoCtrProxy() {
    try {
      tipoMovimentoCtr = (new proxy.TipoMovimentoCtrServiceLocator()).getTipoMovimentoCtrPort();
      if (tipoMovimentoCtr != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tipoMovimentoCtr)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tipoMovimentoCtr)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tipoMovimentoCtr != null)
      ((javax.xml.rpc.Stub)tipoMovimentoCtr)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public proxy.TipoMovimentoCtr getTipoMovimentoCtr() {
    if (tipoMovimentoCtr == null)
      _initTipoMovimentoCtrProxy();
    return tipoMovimentoCtr;
  }
  
  public proxy.ResponseTipoMovimento modificaTM(proxy.TipoMovimento arg0) throws java.rmi.RemoteException{
    if (tipoMovimentoCtr == null)
      _initTipoMovimentoCtrProxy();
    return tipoMovimentoCtr.modificaTM(arg0);
  }
  
  public proxy.ResponseTipoMovimento ritornaListaTM() throws java.rmi.RemoteException{
    if (tipoMovimentoCtr == null)
      _initTipoMovimentoCtrProxy();
    return tipoMovimentoCtr.ritornaListaTM();
  }
  
  public proxy.ResponseTipoMovimento inserisciTM(proxy.TipoMovimento arg0) throws java.rmi.RemoteException{
    if (tipoMovimentoCtr == null)
      _initTipoMovimentoCtrProxy();
    return tipoMovimentoCtr.inserisciTM(arg0);
  }
  
  public proxy.ResponseTipoMovimento cancellaTM(proxy.TipoMovimento arg0) throws java.rmi.RemoteException{
    if (tipoMovimentoCtr == null)
      _initTipoMovimentoCtrProxy();
    return tipoMovimentoCtr.cancellaTM(arg0);
  }
  
  public proxy.ResponseTipoMovimento ritornaTM(int arg0) throws java.rmi.RemoteException{
    if (tipoMovimentoCtr == null)
      _initTipoMovimentoCtrProxy();
    return tipoMovimentoCtr.ritornaTM(arg0);
  }
  
  
}