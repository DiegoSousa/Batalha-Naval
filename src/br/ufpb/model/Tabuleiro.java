package br.ufpb.model;

import br.ufpb.exception.AfundouException;

public class Tabuleiro {
  
  private Embarcacao[][] tabuleiro;
  
  public Tabuleiro() {
    this.tabuleiro = new Embarcacao[15][15];
  }
  
  public Tabuleiro(int n, int m) {
    this.tabuleiro = new Embarcacao[n][m];
  }
  
  private String capitalize(String s) {
    return s.toUpperCase().substring(0,1) + s.toLowerCase().substring(1);
  }
  
  public void putEmbarcacao(String tipo, int x1, int y1, int x2, int y2) 
      throws Exception {
    String className;
    if(tipo.contains("_")) {
      String[] names = tipo.split("_");
      className = capitalize(names[0]) + capitalize(names[1]);
    } else {
      className = capitalize(tipo);
    }
    Embarcacao emb = (Embarcacao) Class.forName(getClass()
        .getPackage()+"."+className).newInstance();
    for(int i = this.tabuleiro.length-1; i >= 0; i--) {
      for(int j = 0; j < this.tabuleiro[i].length; j++) {
        if(i == x1-1 && j == y1-1) {
          if(x2 > x1) {
            for(int k = x1-1; k < x2; k++) {
              this.tabuleiro[k][j] = emb;
              //System.out.println(tabuleiro[k][j]); DEBUG
            } 
          } else if(x1 == x2 && i == x2-1) {
            for (int k = y1-1; k < y2; k++) {
              this.tabuleiro[i][k] = emb;
              //System.out.println(tabuleiro[i][k]); DEBUG
            }
          }
        }
      }
    }
  }

  
  public void shootAt(int x, int y) throws AfundouException {
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
