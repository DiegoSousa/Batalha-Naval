package br.ufpb.model;

import br.ufpb.exception.AfundouException;

public interface Embarcacao {
  
  Tipo getTipo();
  
  void setTipo(Tipo tipo);
  
  int getLife();
  
  void hit() throws AfundouException;
  																	
}
