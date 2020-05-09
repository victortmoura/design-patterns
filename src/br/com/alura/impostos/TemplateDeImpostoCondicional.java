package br.com.alura.impostos;

import br.com.alura.Orcamento;
import br.com.alura.interfaces.Imposto;

public abstract class TemplateDeImpostoCondicional implements Imposto {

	
	/**
	 * Ao adicionar o modificador de acesso: final, garantimos
	 * que todas as classes filhas dessa classe pai nao consigam
	 * sobreescrever esse metodo, para que nao haja uma 
	 * possivel mudanca no comportamento 
	 * */
	@Override
	public final double calcula(Orcamento orcamento) {
		if(deveUsarMaximaTaxacao(orcamento)) {
			return maximaTaxacao(orcamento);
		} else {
			return minimaTaxacao(orcamento);
		}
	}

	protected abstract double minimaTaxacao(Orcamento orcamento);

	protected abstract double maximaTaxacao(Orcamento orcamento);

	protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

}
