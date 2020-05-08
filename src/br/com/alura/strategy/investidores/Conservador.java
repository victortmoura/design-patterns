package br.com.alura.strategy.investidores;

import br.com.alura.strategy.Conta;
import br.com.alura.strategy.interfaces.Investimento;

public class Conservador implements Investimento {

	@Override
	public double calcula(Conta conta) {
		return conta.getSaldo() * 0.008;
	}
	
	@Override
	public String toString() {
		return "Conservador";
	}

}
