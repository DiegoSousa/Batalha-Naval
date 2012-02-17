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

	private int tam;
	private Tipo tipo;
	private int life;

	public Patrulha(int tam, Tipo tipo, int life) {
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
