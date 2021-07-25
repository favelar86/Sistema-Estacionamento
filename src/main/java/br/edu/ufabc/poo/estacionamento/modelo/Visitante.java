package br.edu.ufabc.poo.estacionamento.modelo;

import java.util.ArrayList;

import br.edu.ufabc.poo.estacionamento.enums.Predios;

public class Visitante extends Usuario {
	
	private double cpf;
	private Predios predio;

	public Visitante(String nome, double cpf, Predios predio, ArrayList<Veiculo> veiculos) {
		super(nome, veiculos);
		this.cpf = cpf;
		this.predio = predio;
	}

	public double getCpf() {
		return cpf;
	}

	public Predios getPredio() {
		return predio;
	}

}
