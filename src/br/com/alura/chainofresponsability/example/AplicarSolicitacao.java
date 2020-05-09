package br.com.alura.chainofresponsability.example;

import br.com.alura.Conta;
import br.com.alura.interfaces.Formato;

public class AplicarSolicitacao {

	public String aplica(Requisicao requisicao, Conta conta) {
		Formato xml = new XML();
		Formato csv = new CSV();
		Formato porcento = new Porcento();
		Formato semFormato = new SemFormato();
		
		xml.setProximo(csv);
		csv.setProximo(porcento);
		porcento.setProximo(semFormato);
		
		return xml.formatar(requisicao, conta);
	}

}
