package br.edu.ufabc.poo.estacionamento.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Usuario {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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

	public String Entrar() {
		
		dataEntrada = new Date();
		return sdf.format(dataEntrada);
	}
	
	public String Sair() {
		
		dataSaida = new Date();
		return sdf.format(dataSaida);
	}
	
}
