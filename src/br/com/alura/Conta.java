package br.com.alura;

public class Conta {

	private String nomeTitular;
	private String agencia;
	private int numeroConta;
	private double saldo;
	
	public Conta(double saldo, String nomeTitular) {
		this.saldo = saldo;
		this.nomeTitular = nomeTitular;
	}
	
	public Conta(String nomeTitular, String agencia, int numeroConta, double saldo) {
		super();
		this.nomeTitular = nomeTitular;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
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

	public String getAgencia() {
		return agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}
}
