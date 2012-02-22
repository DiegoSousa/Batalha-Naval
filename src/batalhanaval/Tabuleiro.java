package batalhanaval;

import java.sql.*;

public class Tabuleiro {
  
  private static final int MIN_ALT = 15;
  
  private static final int MIN_LARG = 15;
  
  private static final String ACERTOU = "ACERTOU";
  
  private static final String ERROU = "AGUA";
  
  private static final String AFUNDOU = "AFUNDOU ";
  
  private static final String TIRO_EXEC = "TIRO JA EXECUTADO";
  
  private static final String JOG_INVAL = "JOGADA INVALIDA";
  
  private static final String FIM = "FIM DE JOGO";
  
  private Embarcacao[][] tabuleiro;
  
  private int[][] history;
  
  private int altura;
  
  private int largura;
  
  private int embRestantes;
  
  public Tabuleiro() {
    this.largura = MIN_LARG;
    this.altura = MIN_ALT;
    this.tabuleiro = new Embarcacao[MIN_LARG][MIN_ALT];
    this.history = new int[MIN_LARG][MIN_ALT];
    embRestantes = 0;
  }
  
  public Tabuleiro(int n, int m) {
    this.largura = n;
    this.altura = m;
    this.tabuleiro = new Embarcacao[n][m];
    embRestantes = 0;
  }
  
  public int getAltura() {
    return this.altura;
  }
  
  public void setAltura(int altura) {
    this.altura = altura;
  }
  
  public int getLargura() {
    return this.largura;
  }
  
  public void setLargura(int largura) {
    this.largura = largura;
  }
  
  private String capitalize(String s) {
    return s.toUpperCase().substring(0,1) + s.toLowerCase().substring(1);
  }
  
  public void addEmbarcacao(String tipo, int x1, int y1, int x2, int y2) {
    try {
      String className;
      if(tipo.contains("_")) {
        String[] names = tipo.split("_");
        className = capitalize(names[0]) + capitalize(names[1]);
      } else {
        className = capitalize(tipo);
      }
      embRestantes++;
      Embarcacao emb = (Embarcacao) Class.forName(getClass()
          .getPackage().getName()+"."+className).newInstance();
      for(int i = this.tabuleiro.length-1; i >= 0; i--) {
        for(int j = 0; j < this.tabuleiro[i].length; j++) {
          if(i == x1-1 && j == y1-1) {
            if(x2 > x1) {
              for(int k = x1-1; k < x2; k++) {
                this.tabuleiro[k][j] = emb;
              } 
            } else if(x1 == x2 && i == x2-1) {
              for (int k = y1-1; k < y2; k++) {
                this.tabuleiro[i][k] = emb;
              }
            }
          }
        }
      } 
    } catch(Exception e) {
      //TODO
      //Exception lancada apos tentar instanciar por reflexao
      //encapsular essa exception em uma RuntimeException criada por n—s.
    }
  }

  public Embarcacao[][] getTabuleiro() {
    return this.tabuleiro;
  }
  
  public String shootAt(int x, int y) throws AfundouException {
    try {
      if(this.history[x][y] == 0) {
        this.history[x][y] = 1;
        if(this.tabuleiro[x][y] != null) {
          try {
            this.tabuleiro[x][y].hit();
            this.tabuleiro[x][y] = null;
            return ACERTOU;
          } catch(Exception e) {
            embRestantes--;
            Embarcacao em = this.tabuleiro[x][y];
            this.tabuleiro[x][y] = null;
            if(embRestantes == 0) {
              return AFUNDOU + em.getTipo() + "\n" + FIM;
            }
            return AFUNDOU + em.getTipo();
          }
        } else {
          return ERROU;
        }
      } else {
        return TIRO_EXEC;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      return JOG_INVAL;
    }
  }
}
