package br.com.alura.interfaces;

import br.com.alura.Conta;
import br.com.alura.chainofresponsability.example.Requisicao;

public interface Formato {
	
	String formatar(Requisicao requisicao, Conta conta);

	void setProximo(Formato proximo);
	
}
