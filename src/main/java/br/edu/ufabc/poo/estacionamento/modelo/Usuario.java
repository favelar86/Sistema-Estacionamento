package br.edu.ufabc.poo.estacionamento.modelo;

import java.util.ArrayList;
import java.util.Date;

public abstract class Usuario {
	
	protected int id;
	protected String nome;
	protected String telefone;
	protected ArrayList<veiculo> veiculos;
	protected Date dataEntrada;
	protected Date dataSaida;
	
	public Usuario(int id, String nome, ArrayList<veiculo> veiculos) {
		super();
		this.id = id;
		this.nome = nome;
		this.veiculos = veiculos;
	}
	
	public abstract String Entrar();
	
	public abstract String Sair();
	
}
