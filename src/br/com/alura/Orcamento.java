package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.interfaces.EstadoDeUmOrcamento;

public class Orcamento {
	
	protected double valor;
	private final List<Item> itens;
	protected EstadoDeUmOrcamento estadoAtual;
	
	public Orcamento(double valor) {
		this.valor = valor;
		this.itens = new ArrayList<Item>();
		this.estadoAtual = new EmAprovacao();
	}
	
	public void aplicaDescontoExtra() {
		estadoAtual.aplicaDescontoExtra(this);
	}
	
	 public void aprova() {
        estadoAtual.aprova(this);
      }

      public void reprova() {
        estadoAtual.reprova(this);
      }

      public void finaliza() {
        estadoAtual.finaliza(this);
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
