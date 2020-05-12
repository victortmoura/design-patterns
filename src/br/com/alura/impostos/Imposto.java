package br.com.alura.impostos;

import br.com.alura.Orcamento;

public abstract class Imposto {

	protected final Imposto outroImposto;
	
	public Imposto(Imposto imposto) {
		this.outroImposto = imposto;
	}

	public Imposto() {
		 this.outroImposto = null;
	}
	
	protected double calculoDoOutroImposto(Orcamento orcamento) {
		if(outroImposto == null) return 0;
		return outroImposto.calcula(orcamento);
	}
	
	public abstract double calcula(Orcamento orcamento);
	
}
