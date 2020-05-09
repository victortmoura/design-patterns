package br.com.alura.strategy;

import br.com.alura.strategy.descontos.DescontoPorMaisDeCincoItens;
import br.com.alura.strategy.descontos.DescontoPorMaisDeQuinhentosReais;
import br.com.alura.strategy.descontos.DescontoPorVendaCasada;
import br.com.alura.strategy.interfaces.Desconto;

public class CalculadorDeDescontos {
	
	public double calcula(Orcamento orcamento) {
		Desconto d1 = new DescontoPorMaisDeCincoItens();
		Desconto d2 = new DescontoPorMaisDeQuinhentosReais();
		Desconto d3 = new DescontoPorVendaCasada();
		Desconto d4 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		
		return d1.desconta(orcamento);
	}
}
