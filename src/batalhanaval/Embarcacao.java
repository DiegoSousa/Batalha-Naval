package batalhanaval;


public interface Embarcacao {
  
  Tipo getTipo();
  
  void setTipo(Tipo tipo);
  
  int getLife();
  
  void hit() throws AfundouException;
  																	
}
