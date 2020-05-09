package br.com.alura.chainofresponsability.example;

import br.com.alura.enums.FormatoEnum;

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
