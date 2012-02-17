/**
 * 
 */
package br.ufpb.model;

import br.ufpb.exception.AfundouException;

public class Submarino implements Embarcacao {

	private int tam;
	private Tipo tipo;
	private int life;

	public Submarino(int tam, Tipo tipo, int life) {
		this.tam = tam;
		this.tipo = tipo;
		this.life = life;
	}

	@Override
	public int getTamanho() {
		return tam;
	}

	@Override
	public void setTamanho(int tam) {
		this.tam = tam;
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
