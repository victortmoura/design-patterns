package br.com.alura.strategy;

public class TesteDeImpostos {
	
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(500);
		Imposto icms = new ICMS();
		Imposto iss = new ISS();
		
		CalculadorDeImpostos calculadorDeImpostos = new CalculadorDeImpostos();
		
		calculadorDeImpostos.realizaCalculo(orcamento, icms);
		calculadorDeImpostos.realizaCalculo(orcamento, iss);
	}
}
