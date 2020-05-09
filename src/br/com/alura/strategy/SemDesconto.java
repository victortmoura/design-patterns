package br.com.alura.strategy;

import br.com.alura.strategy.interfaces.Desconto;

public class SemDesconto implements Desconto {

	@Override
	public double desconta(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto proximo) {}

}
