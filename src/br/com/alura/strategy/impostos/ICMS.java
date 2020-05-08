package br.com.alura.strategy.impostos;

import br.com.alura.strategy.Orcamento;
import br.com.alura.strategy.interfaces.Imposto;

public class ICMS implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + 50;
	}
	
}
