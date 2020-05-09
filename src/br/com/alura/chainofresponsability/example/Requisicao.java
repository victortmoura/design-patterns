package br.com.alura.chainofresponsability.example;

public class Requisicao {
	
	private FormatoEnum formato;

	public Requisicao(FormatoEnum formato) {
		super();
		this.formato = formato;
	}

	public FormatoEnum getFormato() {
		return formato;
	}
	
}
