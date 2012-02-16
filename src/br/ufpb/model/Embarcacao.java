package br.ufpb.model;

public interface Embarcacao {

  int getTamanho();
  
  void setTamanho(int tam);
  
  Tipo getTipo();
  
  void setTipo(Tipo tipo);
  
  int getLife();
  
  void hit() throws Exception; //Criar exception AfundouException.
  
}
