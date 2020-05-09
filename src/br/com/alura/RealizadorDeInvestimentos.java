package br.com.alura;

import br.com.alura.interfaces.Investimento;

public class RealizadorDeInvestimentos {
	
	public void realiza(Conta conta, Investimento investimento) {
		double resultado = investimento.calcula(conta);
		
		conta.deposita(resultado * 0.75);
		
		System.out.println("Novo saldo: " + conta.getSaldo() + " para investidor " + investimento.toString());
	}
	
}
