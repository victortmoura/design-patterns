package br.com.alura.relatorios;

import java.util.List;

import br.com.alura.Conta;

/**
 * Classe que representa um TEMPLATE METHOD
 * */
public abstract class Relatorio {
	
	protected abstract void cabecalho();
	protected abstract void corpo(List<Conta> contas);
	protected abstract void rodape();
	
	public final void imprime(List<Conta> contas) {
		cabecalho();
		corpo(contas);
		rodape();
	}

}
