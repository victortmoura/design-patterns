package br.com.alura.chainofresponsability.example;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.Conta;
import br.com.alura.interfaces.Formato;

public class XML implements Formato {

	private Formato proximo;

	@Override
	public String formatar(Requisicao requisicao, Conta conta) {
		if(FormatoEnum.XML.equals(requisicao.getFormato())) {
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("Conta", Conta.class);
			return xstream.toXML(conta);
		} else {
			return proximo.formatar(requisicao, conta);
		}
		
	}
	
	@Override
	public void setProximo(Formato proximo) {
		this.proximo = proximo;
	}

}
