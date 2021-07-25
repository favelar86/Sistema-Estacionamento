package br.edu.ufabc.poo.estacionamento.modelo;

import java.util.ArrayList;

public class Funcionario extends Usuario {
	
	private double registro;
	private int numeroVaga;

	public Funcionario(String nome, Veiculo veiculo, double registro) {
		super(nome, veiculo);
		this.registro = registro;
	}

	public double getRegistro() {
		return registro;
	}

	public int getNumeroVaga() {
		return numeroVaga;
	}

}
