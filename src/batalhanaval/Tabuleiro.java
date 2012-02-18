package batalhanaval;


public class Tabuleiro {
  
  private static final int MIN_ALT = 15;
  
  private static final int MIN_LARG = 15;
  
  private Embarcacao[][] tabuleiro;
  
  private int altura;
  
  private int largura;
  
  public Tabuleiro() {
    this.largura = MIN_LARG;
    this.altura = MIN_ALT;
    this.tabuleiro = new Embarcacao[MIN_LARG][MIN_ALT];
  }
  
  public Tabuleiro(int n, int m) {
    this.largura = n;
    this.altura = m;
    this.tabuleiro = new Embarcacao[n][m];
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
  
  public void addEmbarcacao(String tipo, int x1, int y1, int x2, int y2) 
      throws Exception {
    String className;
    if(tipo.contains("_")) {
      String[] names = tipo.split("_");
      className = capitalize(names[0]) + capitalize(names[1]);
    } else {
      className = capitalize(tipo);
    }
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
  }

  public Embarcacao[][] getTabuleiro() {
    return this.tabuleiro;
  }
  
  public String shootAt(int x, int y) throws AfundouException {
    if(this.tabuleiro[x][y] != null) {
      try {
        this.tabuleiro[x][y].hit();
        this.tabuleiro[x][y] = null;
        return "ACERTOU";
      } catch(Exception e) {
        Embarcacao em = this.tabuleiro[x][y];
        this.tabuleiro[x][y] = null;
        return "AFUNDOU " + em.getTipo();
      }
    } else {
      return "AGUA";
    }
  }
}
