package br.com.alura.tests;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.CalculadorDeDescontos;
import br.com.alura.CalculadorDeImpostos;
import br.com.alura.Conta;
import br.com.alura.Item;
import br.com.alura.Orcamento;
import br.com.alura.RealizadorDeInvestimentos;
import br.com.alura.chainofresponsability.example.AplicarSolicitacao;
import br.com.alura.chainofresponsability.example.Requisicao;
import br.com.alura.enums.FormatoEnum;
import br.com.alura.filtros.Filtro;
import br.com.alura.filtros.FiltroMaiorQue500MilReais;
import br.com.alura.filtros.FiltroMenorQue100Reais;
import br.com.alura.impostos.ICCC;
import br.com.alura.impostos.ICMS;
import br.com.alura.impostos.ICPP;
import br.com.alura.impostos.IKCV;
import br.com.alura.impostos.ISS;
import br.com.alura.impostos.Imposto;
import br.com.alura.impostos.ImpostoMuitoAlto;
import br.com.alura.interfaces.Investimento;
import br.com.alura.investidores.Conservador;
import br.com.alura.relatorios.RelatorioComplexo;
import br.com.alura.relatorios.RelatorioSimples;

public class Teste {

	public static void main(String[] args) {
		testeOrcamento();
		testeConta();
		testeDesconto();
		testeDescontoVendaCasada();
		testeChainOfRespXML();
		testeChainOfRespCSV();
		testeChainOfRespPORCENTO();
		testeTemplateMethodICPP();
		testeTemplateMethodIKCV();
		testaRelatorioSimples();
		testaRelatorioComplexo();
		testeImpostosCompostos();
		testeImpostosMuitoAlto();
		testeFiltroConta();
		testesDoDescontoExtra();
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

	private static void testeTemplateMethodICPP() {
		System.out.println("TESTE TemplateMethod ICPP");
		ICPP icpp = new ICPP();
		Orcamento orcamento = new Orcamento(600);
		
		CalculadorDeImpostos calculadorImpostos = new CalculadorDeImpostos();
		calculadorImpostos.realizaCalculo(orcamento, icpp);
		
		System.out.println();
	}
	
	private static void testeTemplateMethodIKCV() {
		System.out.println("TESTE TemplateMethod IKCV");
		IKCV ikcv = new IKCV();
		Orcamento orcamento = new Orcamento(1000);
		orcamento.adicionaItem(new Item("PNEU", 250));
		
		CalculadorDeImpostos calculadorImpostos = new CalculadorDeImpostos();
		calculadorImpostos.realizaCalculo(orcamento, ikcv);
		
		System.out.println();
	}
	
	private static void testaRelatorioSimples() {
		System.out.println("RELATÓRIO SIMPLES");
		RelatorioSimples relatorioSimples = new RelatorioSimples();
		List<Conta> contas = new ArrayList<>();
		Conta conta = new Conta("Victor Moura", "1835-X", 515141, 100);
		Conta conta2 = new Conta("Thalita Moura", "4458-6", 66584, 900);
		Conta conta3 = new Conta("Waleska Moura", "5584-1", 22105, 3000);
		
		contas.add(conta);
		contas.add(conta2);
		contas.add(conta3);
		
		relatorioSimples.imprime(contas);
		System.out.println();
	}
	private static void testaRelatorioComplexo() {
		System.out.println("RELATÓRIO COMPLEXO");
		RelatorioComplexo relatorioComplexo = new RelatorioComplexo();
		
		List<Conta> contas = new ArrayList<>();
		Conta conta = new Conta("Victor Moura", "1835-X", 515141, 100);
		Conta conta2 = new Conta("Thalita Moura", "4458-6", 66584, 900);
		Conta conta3 = new Conta("Waleska Moura", "5584-1", 22105, 3000);
		
		contas.add(conta);
		contas.add(conta2);
		contas.add(conta3);
		
		relatorioComplexo.imprime(contas);
		System.out.println();
	}

	private static void testeImpostosCompostos() {
		System.out.println("IMPOSTOS COMPOSTOS");
		Orcamento orcamento = new Orcamento(1000);
		Imposto icmsComIss = new ICMS(new ISS());
		
		CalculadorDeImpostos calculadorDeImpostos = new CalculadorDeImpostos();
		calculadorDeImpostos.realizaCalculo(orcamento, icmsComIss);
		
		System.out.println();
	}
	
	private static void testeImpostosMuitoAlto() {
		System.out.println("IMPOSTO MUITO ALTO");
		Orcamento orcamento = new Orcamento(500);
		Imposto impostoMuitoAlto = new ImpostoMuitoAlto(new ICMS());
		
		CalculadorDeImpostos calculadorDeImpostos = new CalculadorDeImpostos();
		calculadorDeImpostos.realizaCalculo(orcamento, impostoMuitoAlto);
		
		System.out.println();
	}
	
	private static void testeFiltroConta() {
		System.out.println("FILTRO CONTA");
		Conta conta1 = new Conta(50, "A");
		Conta conta2 = new Conta(150, "B");
		Conta conta3 = new Conta(360, "C");
		Conta conta4 = new Conta(500, "D");
		Conta conta5 = new Conta(850000, "E");
		List<Conta> contas = new ArrayList<Conta>();
		
		contas.add(conta1);
		contas.add(conta2);
		contas.add(conta3);
		contas.add(conta4);
		contas.add(conta5);
		
		// FILTRO COMPOSTO POR OUTRO FILTRO
		
		Filtro filtroComposto = new FiltroMenorQue100Reais(new FiltroMaiorQue500MilReais());
		List<Conta> contasFiltradas = filtroComposto.filtra(contas);
		
		for (Conta c : contasFiltradas) {
			System.out.println(c.getNomeTitular() +" "+ c.getSaldo());
		}
		
		System.out.println();
	}
	
	private static void testesDoDescontoExtra() {
		System.out.println("FILTRO CONTA");
		Orcamento reforma = new Orcamento(500.0);
		reforma.aplicaDescontoExtra();
		
		System.out.println(reforma.getValor()); // imprime 475,00 pois descontou 5%
        reforma.aprova(); // aprova nota!

        reforma.aplicaDescontoExtra();
        System.out.println(reforma.getValor()); // imprime 465,50 pois descontou 2%

        reforma.finaliza();

        // reforma.aplicaDescontoExtra(); lancaria excecao, pois não pode dar desconto nesse estado
        // reforma.aprova(); lança exceção, pois não pode ir para aprovado
		
		System.out.println();
	}

}
