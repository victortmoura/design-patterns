package br.com.alura.filtros;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.Conta;

public class FiltroMenorQue100Reais extends Filtro {
	
	public FiltroMenorQue100Reais(Filtro outroFiltro) {
		super(outroFiltro);
	}
	
	public FiltroMenorQue100Reais() {
		super();
	}

	@Override
	public List<Conta> filtra(List<Conta> contas) {
		List<Conta> filtrada = new ArrayList<Conta>();
		
		for (Conta conta : contas) {
			if(conta.getSaldo() < 100) {
				filtrada.add(conta);
			}
		}
		
		filtrada.addAll(proximo(contas));
		return filtrada;
	}

}
