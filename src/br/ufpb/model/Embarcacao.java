package br.ufpb.model;

import br.ufpb.exception.AfundouException;

public interface Embarcacao {

  int getTamanho();
  
  void setTamanho(int tam);
  
  Tipo getTipo();
  
  void setTipo(Tipo tipo);
  
  int getLife();
  
  void hit() throws AfundouException;
  																	
}
