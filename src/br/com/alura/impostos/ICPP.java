package br.com.alura.impostos;

import br.com.alura.Orcamento;

public class ICPP extends TemplateAbstractDeImpostoCondicional {

	public ICPP(Imposto outroImposto) {
		super(outroImposto);
	}

	public ICPP() {
		super();
	}
	
	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + calculoDoOutroImposto(orcamento);
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07 + calculoDoOutroImposto(orcamento);
	}

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500;
	}

}
