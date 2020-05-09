package br.com.alura.impostos;

import br.com.alura.Orcamento;
import br.com.alura.interfaces.Imposto;

public class ISS implements Imposto {

	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

}
