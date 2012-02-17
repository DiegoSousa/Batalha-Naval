package br.ufpb.model;

import br.ufpb.exception.AfundouException;

public class Destroyer implements Embarcacao {
  
  private Tipo tipo;
  private int life;
 
  protected Destroyer(Tipo tipo, int life) {
    this.tipo = tipo;
    this.life = life;
  }

  public Destroyer() {
    this.tipo = Tipo.DESTROYER;
    this.life = Tipo.DESTROYER.getTam();
  }
  
  @Override
  public Tipo getTipo() {
    return this.tipo;
  }

  @Override
  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  @Override
  public int getLife() {
    return this.life;
  }

  @Override
  public void hit() throws AfundouException {
    this.life--;
    if(life == 0) throw new AfundouException("AFUNDOU");
  }
}
