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
	protected ArrayList<Veiculo> veiculos;
	protected Date dataEntrada;
	protected Date dataSaida;
	
	public Usuario(String nome, ArrayList<Veiculo> veiculos) {
		this.id = ultimoId++;
		this.nome = nome;
		this.veiculos = veiculos;
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
