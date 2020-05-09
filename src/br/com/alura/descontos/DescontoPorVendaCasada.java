package br.com.alura.descontos;

import br.com.alura.Item;
import br.com.alura.Orcamento;
import br.com.alura.interfaces.Desconto;

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
