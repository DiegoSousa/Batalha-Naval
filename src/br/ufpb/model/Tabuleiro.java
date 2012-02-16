package br.ufpb.model;

public class Tabuleiro {
  
  private Embarcacao[][] tabuleiro;
  
  public Tabuleiro() {
    this.tabuleiro = new Embarcacao[15][15];
  }
  
  public Tabuleiro(int n, int m) {
    this.tabuleiro = new Embarcacao[n][m];
  }
  
  public void putEmbarcacao(int x1, int y1, int x2, int y2) {
    //TODO
  }
  
  public void shootAt(int x, int y) throws Exception {
    if(this.tabuleiro[x][y] != null) {
      try {
        tabuleiro[x][y].hit();
        tabuleiro[x][y] = null;
      } catch(Exception e) {
        System.out.println("AFUNDOU " + tabuleiro[x][y].getTipo());
        tabuleiro[x][y] = null;
      }
      System.out.println("ACERTOU");
    } else {
      System.out.println("AGUA");
    }
  }
}
