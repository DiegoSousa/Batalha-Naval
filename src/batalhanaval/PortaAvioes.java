package batalhanaval;	


public class PortaAvioes implements Embarcacao {

	private Tipo tipo;
	private int life;

	public PortaAvioes() {
		this.tipo = Tipo.PORTA_AVIOES;
		this.life = Tipo.PORTA_AVIOES.getTam();
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