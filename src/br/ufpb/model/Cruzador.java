package br.ufpb.model;

public class Cruzador extends Destroyer {
  public Cruzador() {
    super(Tipo.CRUZADOR.getTam(), Tipo.CRUZADOR, Tipo.CRUZADOR.getTam());
  }
}