package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orcamento {
	
	private final double valor;
	private final List<Item> itens;
	
	public Orcamento(double valor) {
		this.valor = valor;
		this.itens = new ArrayList<Item>();
	}
	
	public boolean contemItem(String itemProcurado) {
		for (Item item : itens) {
			if(itemProcurado.equals(item.getNome())) {
				return true;
			}
		}
		return false;
	}

	public void adicionaItem(Item item) {
		itens.add(item);
	}
	
	public double getValor() {
		return valor;
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}
	
}
