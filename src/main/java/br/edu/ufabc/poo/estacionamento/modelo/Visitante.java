package br.edu.ufabc.poo.estacionamento.modelo;

import java.util.ArrayList;

import br.edu.ufabc.poo.estacionamento.enums.Predios;

public class Visitante extends Usuario {
	
	private String cpf;
	private Predios predio;

	public Visitante(String nome, String cpf, Predios predio, Veiculo veiculo) {
		super(nome, veiculo);
		this.cpf = cpf;
		this.predio = predio;
	}

	public String getCpf() {
		return cpf;
	}

	public Predios getPredio() {
		return predio;
	}

}
