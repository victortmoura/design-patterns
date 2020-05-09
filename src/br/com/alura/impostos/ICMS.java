package br.com.alura.impostos;

import br.com.alura.Orcamento;
import br.com.alura.interfaces.Imposto;

public class ICMS implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + 50;
	}
	
}
