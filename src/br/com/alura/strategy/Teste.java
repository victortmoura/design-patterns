package br.com.alura.strategy;

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
				
	}
}
