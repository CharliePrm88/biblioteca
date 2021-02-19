package proxy;

public class ContoCorrenteCtrProxy implements proxy.ContoCorrenteCtr {
  private String _endpoint = null;
  private proxy.ContoCorrenteCtr contoCorrenteCtr = null;
  
  public ContoCorrenteCtrProxy() {
    _initContoCorrenteCtrProxy();
  }
  
  public ContoCorrenteCtrProxy(String endpoint) {
    _endpoint = endpoint;
    _initContoCorrenteCtrProxy();
  }
  
  private void _initContoCorrenteCtrProxy() {
    try {
      contoCorrenteCtr = (new proxy.ContoCorrenteCtrServiceLocator()).getContoCorrenteCtrPort();
      if (contoCorrenteCtr != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)contoCorrenteCtr)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)contoCorrenteCtr)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (contoCorrenteCtr != null)
      ((javax.xml.rpc.Stub)contoCorrenteCtr)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public proxy.ContoCorrenteCtr getContoCorrenteCtr() {
    if (contoCorrenteCtr == null)
      _initContoCorrenteCtrProxy();
    return contoCorrenteCtr;
  }
  
  public proxy.ResponseContoCorrente ritornaCC(int arg0) throws java.rmi.RemoteException{
    if (contoCorrenteCtr == null)
      _initContoCorrenteCtrProxy();
    return contoCorrenteCtr.ritornaCC(arg0);
  }
  
  public proxy.ResponseContoCorrente modificaCC(proxy.ContoCorrente arg0) throws java.rmi.RemoteException{
    if (contoCorrenteCtr == null)
      _initContoCorrenteCtrProxy();
    return contoCorrenteCtr.modificaCC(arg0);
  }
  
  public proxy.ResponseContoCorrente ritornaListaCC() throws java.rmi.RemoteException{
    if (contoCorrenteCtr == null)
      _initContoCorrenteCtrProxy();
    return contoCorrenteCtr.ritornaListaCC();
  }
  
  public proxy.ResponseContoCorrente cancellaCC(proxy.ContoCorrente arg0) throws java.rmi.RemoteException{
    if (contoCorrenteCtr == null)
      _initContoCorrenteCtrProxy();
    return contoCorrenteCtr.cancellaCC(arg0);
  }
  
  public proxy.ResponseContoCorrente inserisciCC(proxy.ContoCorrente arg0) throws java.rmi.RemoteException{
    if (contoCorrenteCtr == null)
      _initContoCorrenteCtrProxy();
    return contoCorrenteCtr.inserisciCC(arg0);
  }
  
  
}