package br.com.alura.relatorios;

import java.util.List;

import br.com.alura.Conta;

public class RelatorioSimples extends Relatorio {

	@Override
	protected void cabecalho() {
		System.out.println("BANCO INTER");
	}

	@Override
	protected void corpo(List<Conta> contas) {
		for (Conta conta : contas) {
			System.out.println(conta.getNomeTitular() 
					+ " possui: R$ " + conta.getSaldo());
		}
	}
	
	@Override
	protected void rodape() {
		System.out.println("0800");
		
	}

}
