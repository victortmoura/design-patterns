package br.com.alura.strategy.investidores;

import java.util.Random;

import br.com.alura.strategy.Conta;
import br.com.alura.strategy.interfaces.Investimento;

public class Arrojado implements Investimento {

	private Random random;
	
	public Arrojado() {
		this.random = new Random();
	}
	
	@Override
	public double calcula(Conta conta) {
		int chute = random.nextInt(10);
		
		if(chute >= 0 && chute <= 1) {
			return conta.getSaldo() * 0.05;
		} else if(chute >= 2 && chute <= 4) {
			return conta.getSaldo() * 0.03;
		} else {
			return conta.getSaldo() * 0.006;
		}
		
	}
	
	@Override
	public String toString() {
		return "Arrojado";
	}

}
