package br.uscsal.testequalidade20162.radio.exceptions;

public class RegistroNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RegistroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}
