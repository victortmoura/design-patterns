package br.com.alura.relatorios;

import java.util.List;

import br.com.alura.Conta;

public class RelatorioComplexo extends Relatorio {

	@Override
	protected void cabecalho() {
		System.out.println("BANCO NUBANK");
		System.out.println("Rua Marquenze de Oliveira, nº 10");
		System.out.println("0800");
		
	}

	@Override
	protected void corpo(List<Conta> contas) {
		for (Conta conta : contas) {
			System.out.println(conta.getNomeTitular() 
					+ " possui: R$ " + conta.getSaldo()
					+ " agência: " + conta.getAgencia()
					+ " e número da conta " + conta.getNumeroConta());
		}
	}
	
	@Override
	protected void rodape() {
		System.out.println("nubank@ogmail.com");
		System.out.println("09/05/2020");
	}

}
