package br.edu.ufabc.poo.estacionamento.modelo;

import java.util.ArrayList;

public class Funcionario extends Usuario {
	
	private double registro;
	private int numeroVaga;

	public Funcionario(int id, String nome, ArrayList<veiculo> veiculos, double registro) {
		super(id, nome, veiculos);
		this.registro = registro;
	}

	@Override
	public String Entrar() {
		return null;
	}

	@Override
	public String Sair() {
		return null;
	}

}
