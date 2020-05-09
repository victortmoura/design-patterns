package br.com.alura.chainofresponsability.example;

import br.com.alura.Conta;
import br.com.alura.interfaces.Formato;

public class SemFormato implements Formato {

	@Override
	public String formatar(Requisicao requisicao, Conta conta) {
		return null;
	}
	
	@Override
	public void setProximo(Formato proximo) {
//		Nao ha implementacao para esse metodo
//		por ser o fim da cadeia.
	}

}
