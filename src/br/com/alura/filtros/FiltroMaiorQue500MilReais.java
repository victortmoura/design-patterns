package br.com.alura.filtros;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.Conta;

public class FiltroMaiorQue500MilReais extends Filtro {

	public FiltroMaiorQue500MilReais(Filtro outroFiltro) {
		super(outroFiltro);
	}
	
	public FiltroMaiorQue500MilReais() {
		super();
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		
		for (Conta conta : contas) {
			if(conta.getSaldo() > 500000) {
				filtrada.add(conta);
			}
		}
		
		filtrada.addAll(proximo(contas));
		return filtrada;
	}

}
