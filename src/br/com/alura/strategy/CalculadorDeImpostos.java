package br.com.alura.strategy;

import br.com.alura.strategy.interfaces.Imposto;

public class CalculadorDeImpostos {

	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		double valor = imposto.calcula(orcamento);
		System.out.println(valor);
	}
	
}
