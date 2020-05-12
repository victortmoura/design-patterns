package br.com.alura.impostos;

import br.com.alura.Orcamento;

public class ICCC extends Imposto {

	public ICCC(Imposto outroImposto) {
		super(outroImposto);
	}
	
	public ICCC() {}

	@Override
	public double calcula(Orcamento orcamento) {
		
		double valor = 0;
		
		if(orcamento.getValor() < 1000) {
			valor = orcamento.getValor() * 0.05 + calculoDoOutroImposto(orcamento);
		} else if(orcamento.getValor() >= 1000 && orcamento.getValor() <= 3000) {
			valor = orcamento.getValor() * 0.07 + calculoDoOutroImposto(orcamento);
		} else {
			valor = orcamento.getValor() * 0.08 + 30 + calculoDoOutroImposto(orcamento);
		}
		
		return valor;
	}

}
