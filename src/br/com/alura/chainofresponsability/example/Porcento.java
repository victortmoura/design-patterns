package br.com.alura.chainofresponsability.example;

import br.com.alura.Conta;
import br.com.alura.enums.FormatoEnum;
import br.com.alura.interfaces.Formato;

public class Porcento implements Formato {

	private Formato proximo;

	@Override
	public String formatar(Requisicao requisicao, Conta conta) {
		if(FormatoEnum.PORCENTO.equals(requisicao.getFormato())) {
			return conta.getNomeTitular()+"%"+conta.getSaldo();
		} else {
			return proximo.formatar(requisicao, conta);
		}
	}
	
	@Override
	public void setProximo(Formato proximo) {
		this.proximo = proximo;
	}

}
