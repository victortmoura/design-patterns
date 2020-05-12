package br.com.alura;

import br.com.alura.interfaces.EstadoDeUmOrcamento;

public class Reprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Or�amento reprovado n�o recebe desconto extra");
	}

	@Override
	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� reprovado: n�o pode ser aprovaado");
		
	}

	@Override
	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� reprovado");
	}

	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Or�amento j� reprovado");
	}

}
