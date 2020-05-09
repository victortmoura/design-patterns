package br.com.alura.tests;

import br.com.alura.CalculadorDeDescontos;
import br.com.alura.CalculadorDeImpostos;
import br.com.alura.Conta;
import br.com.alura.Item;
import br.com.alura.Orcamento;
import br.com.alura.RealizadorDeInvestimentos;
import br.com.alura.chainofresponsability.example.AplicarSolicitacao;
import br.com.alura.chainofresponsability.example.FormatoEnum;
import br.com.alura.chainofresponsability.example.Requisicao;
import br.com.alura.impostos.ICCC;
import br.com.alura.impostos.ICMS;
import br.com.alura.impostos.ISS;
import br.com.alura.interfaces.Imposto;
import br.com.alura.interfaces.Investimento;
import br.com.alura.investidores.Conservador;

public class Teste {

	public static void main(String[] args) {
		testeOrcamento();
		testeConta();
		testeDesconto();
		testeDescontoVendaCasada();
		testeChainOfRespXML();
		testeChainOfRespCSV();
		testeChainOfRespPORCENTO();
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
		orcamento.adicionaItem(new Item("CANETA", 250));
		orcamento.adicionaItem(new Item("LAPIS", 250));
		orcamento.adicionaItem(new Item("BORRACHA", 250));
		orcamento.adicionaItem(new Item("CADERNO", 250));
		orcamento.adicionaItem(new Item("BOLSA", 250));

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

	private static void testeChainOfRespXML() {
		System.out.println("TESTE ChainOfResp XML");
		Requisicao requisicao = new Requisicao(FormatoEnum.XML);
		Conta conta = new Conta(500, "Victor Moura");

		AplicarSolicitacao aplicarSolicitacao = new AplicarSolicitacao();
		String contaFormatada = aplicarSolicitacao.aplica(requisicao, conta);

		System.out.println(contaFormatada);
		System.out.println();
	}

	private static void testeChainOfRespCSV() {
		System.out.println("TESTE ChainOfResp CSV");
		Requisicao requisicao = new Requisicao(FormatoEnum.CSV);
		Conta conta = new Conta(500, "Victor Moura");

		AplicarSolicitacao aplicarSolicitacao = new AplicarSolicitacao();
		String contaFormatada = aplicarSolicitacao.aplica(requisicao, conta);

		System.out.println(contaFormatada);
		System.out.println();
	}

	private static void testeChainOfRespPORCENTO() {
		System.out.println("TESTE ChainOfResp PORCENTO");
		Requisicao requisicao = new Requisicao(FormatoEnum.PORCENTO);
		Conta conta = new Conta(500, "Victor Moura");

		AplicarSolicitacao aplicarSolicitacao = new AplicarSolicitacao();
		String contaFormatada = aplicarSolicitacao.aplica(requisicao, conta);

		System.out.println(contaFormatada);
		System.out.println();
	}

}
