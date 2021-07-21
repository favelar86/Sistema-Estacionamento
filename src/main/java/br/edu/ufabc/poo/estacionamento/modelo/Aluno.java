package br.edu.ufabc.poo.estacionamento.modelo;

import java.util.ArrayList;
import br.edu.ufabc.poo.estacionamento.enums.Turno;

public class Aluno extends Usuario {
	
	private double ra;
	private Turno turno;

	public Aluno(int id, String nome, ArrayList<veiculo> veiculos, double ra, Turno turno) {
		super(id, nome, veiculos);
		this.ra = ra;
		this.turno = turno;
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
