/**
 * 
 */
package batalhanaval;


public class Submarino implements Embarcacao {

	private Tipo tipo;
	private int life;

	public Submarino() {
		this.tipo = Tipo.SUBMARINO;
		this.life = Tipo.SUBMARINO.getTam();
	}

	@Override
	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;

	}

	@Override
	public int getLife() {
		return life;
	}

	@Override
	public void hit() throws AfundouException {
		this.life--;
		if (life == 0) {
			throw new AfundouException("AFUNDOU");
		}
	}

}
