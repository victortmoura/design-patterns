package br.com.alura.strategy.interfaces;

import br.com.alura.strategy.Orcamento;

public interface Desconto {
	
	double desconta(Orcamento orcamento);
	
	void setProximo(Desconto proximo);
}
