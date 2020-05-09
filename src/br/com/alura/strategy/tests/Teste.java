package br.com.alura.strategy.tests;

import br.com.alura.strategy.CalculadorDeDescontos;
import br.com.alura.strategy.CalculadorDeImpostos;
import br.com.alura.strategy.Conta;
import br.com.alura.strategy.Item;
import br.com.alura.strategy.Orcamento;
import br.com.alura.strategy.RealizadorDeInvestimentos;
import br.com.alura.strategy.impostos.ICCC;
import br.com.alura.strategy.impostos.ICMS;
import br.com.alura.strategy.impostos.ISS;
import br.com.alura.strategy.interfaces.Imposto;
import br.com.alura.strategy.interfaces.Investimento;
import br.com.alura.strategy.investidores.Arrojado;
import br.com.alura.strategy.investidores.Conservador;
import br.com.alura.strategy.investidores.Moderado;

public class Teste {

	public static void main(String[] args) {
		testeOrcamento();
		testeConta();
		testeDesconto();
		testeDescontoVendaCasada();
	}

	public static void testeOrcamento() {
		System.out.println("TESTE ORÇAMENTO");
		Orcamento orcamento = new Orcamento(1500);
		Imposto icms = new ICMS();
		Imposto iss = new ISS();
		Imposto iccc = new ICCC();
		
		CalculadorDeImpostos calculadorDeImpostos = new CalculadorDeImpostos();
		
		calculadorDeImpostos.realizaCalculo(orcamento, icms);
		calculadorDeImpostos.realizaCalculo(orcamento, iss);
		calculadorDeImpostos.realizaCalculo(orcamento, iccc);
		System.out.println();
	}

	public static void testeConta() {
		System.out.println("TESTE CONTA");
		Conta conta = new Conta();
		conta.deposita(100);
		
		Investimento investimento = new Conservador();
//		Investimento investimento = new Moderado();
//		Investimento investimento = new Arrojado();
		
		RealizadorDeInvestimentos realizadorDeInvestimentos = new RealizadorDeInvestimentos();
		realizadorDeInvestimentos.realiza(conta, investimento);
		System.out.println();
				
	}

	public static void testeDesconto() {
		System.out.println("TESTE DESCONTO");
		CalculadorDeDescontos calcular = new CalculadorDeDescontos();
		
		Orcamento orcamento = new Orcamento(1000);
		orcamento.adicionaItem(new Item("CANETA", 250 ));
		orcamento.adicionaItem(new Item("LAPIS", 250 ));
		orcamento.adicionaItem(new Item("BORRACHA", 250 ));
		orcamento.adicionaItem(new Item("CADERNO", 250 ));
		orcamento.adicionaItem(new Item("BOLSA", 250 ));
		
		double desconto = calcular.calcula(orcamento);
		
		System.out.println(desconto);
		System.out.println();
	}

	private static void testeDescontoVendaCasada() {
		System.out.println("TESTE DESCONTO VENDA CASADA");
		CalculadorDeDescontos calcular = new CalculadorDeDescontos();
		
		Orcamento orcamento = new Orcamento(100);
		orcamento.adicionaItem(new Item("CANETA", 50));
		orcamento.adicionaItem(new Item("LAPIS", 10));
		orcamento.adicionaItem(new Item("BORRACHA", 20));
		orcamento.adicionaItem(new Item("CADERNO", 20));
		
		double desconto = calcular.calcula(orcamento);
		
		System.out.println(desconto);
		System.out.println();
	}
}
