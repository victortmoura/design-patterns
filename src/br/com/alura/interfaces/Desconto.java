package br.com.alura.interfaces;

import br.com.alura.Orcamento;

public interface Desconto {
	
	double desconta(Orcamento orcamento);
	
	void setProximo(Desconto proximo);
}
