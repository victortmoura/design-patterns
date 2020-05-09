package br.com.alura;

public class Conta {

	private String nomeTitular;
	private double saldo;
	
	public Conta(double saldo, String nomeTitular) {
		this.saldo = saldo;
		this.nomeTitular = nomeTitular;
	}
	
	public Conta() {
		
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
}
