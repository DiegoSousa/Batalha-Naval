package br.ufpb.model;

public enum Tipo {

  PORTA_AVIOES(5),
  DESTROYER(4),
  CRUZADOR(4),
  SUBMARINO(3),
  PATRULHA(2);
  
  private int tam;
  
  private Tipo(int tam) {
    this.tam = tam;
  }
  
  public int getTam() {
    return this.tam;
  }

}
