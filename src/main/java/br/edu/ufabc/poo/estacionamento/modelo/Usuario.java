package br.edu.ufabc.poo.estacionamento.modelo;

import java.util.Date;

import br.edu.ufabc.poo.estacionamento.modelo.excecao.DomainException;

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

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
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

	public Date entrar() {
		if(this.dataEntrada != null) {
			throw new DomainException("Erro: Usuário já registrou entrada");
		}
		
		return this.dataEntrada = new Date();
	}
	
	public Date sair() {
		if(this.dataEntrada == null) {
			throw new DomainException("Erro: Usuário não registrou entrada");
		}
		
		return this.dataSaida = new Date();
	}
	
}
