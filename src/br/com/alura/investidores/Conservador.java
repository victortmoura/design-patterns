package br.com.alura.investidores;

import br.com.alura.Conta;
import br.com.alura.interfaces.Investimento;

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
