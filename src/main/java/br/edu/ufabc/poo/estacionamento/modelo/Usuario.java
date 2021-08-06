package br.edu.ufabc.poo.estacionamento.modelo;

import java.util.Date;

public abstract class Usuario {
	
	private static int ultimoId = 0;
	
	protected int id;
	protected String nome;
	protected String telefone;
	protected Veiculo veiculo;
	protected Date dataEntrada;
	protected Date dataSaida;
	
	public Usuario(String nome, Veiculo veiculo) {
		this.id = ultimoId++;
		this.nome = nome;
		this.veiculo = veiculo;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public Date Entrar() {
		
		return dataEntrada = new Date();
	}
	
	public Date Sair() {
		
		return dataSaida = new Date();
	}
	
}
