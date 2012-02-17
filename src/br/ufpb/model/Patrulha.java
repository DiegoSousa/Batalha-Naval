/**
 * 
 */
package br.ufpb.model;

import br.ufpb.exception.AfundouException;

/**
 * Description of the class
 * 
 * @author Diego Sousa - www.diegosousa.com
 * @version 1.0 Copyright (C) 2012 Diego Sousa de Azevedo
 */
public class Patrulha implements Embarcacao {

	private Tipo tipo;
	private int life;

	public Patrulha() {
		this.tipo = Tipo.PATRULHA;
		this.life = Tipo.PATRULHA.getTam();
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
