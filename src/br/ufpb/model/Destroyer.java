package br.ufpb.model;


public class Destroyer implements Embarcacao {
  
  private int tam;
  
  private Tipo tipo;
  
  private int life;
  
  protected Destroyer(int tam, Tipo tipo, int life) {
    this.tam = tam;
    this.tipo = tipo;
    this.life = life;
  }
  
  public Destroyer() {
    this.tam = Tipo.DESTROYER.getTam();
    this.tipo = Tipo.DESTROYER;
    this.life = Tipo.DESTROYER.getTam();
  }
  
  @Override
  public int getTamanho() {
    return this.tam;
  }

  @Override
  public void setTamanho(int tam) {
    this.tam = tam;
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
  public void hit() throws Exception {
    this.life--;
    if(life == 0) throw new Exception("AFUNDOU");
  }
  
  
}
