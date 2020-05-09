package br.com.alura.strategy.descontos;

import br.com.alura.strategy.Item;
import br.com.alura.strategy.Orcamento;
import br.com.alura.strategy.interfaces.Desconto;

public class DescontoPorVendaCasada implements Desconto {

	private Desconto proximo;

	@Override
	public double desconta(Orcamento orcamento) {
		if(aconteceuVendaCasada(orcamento)) {
			return orcamento.getValor() * 0.05;
		} else {
			return proximo.desconta(orcamento);
		}
	}

	private boolean aconteceuVendaCasada(Orcamento orcamento) {
		return existe("CANETA", orcamento) && existe("LAPIS", orcamento);
	}

	private boolean existe(String itemProcurado, Orcamento orcamento) {
		return orcamento.contemItem(itemProcurado);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
