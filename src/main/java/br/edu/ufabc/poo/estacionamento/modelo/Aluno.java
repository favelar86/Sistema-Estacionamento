package br.edu.ufabc.poo.estacionamento.modelo;

import java.util.ArrayList;
import br.edu.ufabc.poo.estacionamento.enums.Turno;

public class Aluno extends Usuario {
	
	private double ra;
	private Turno turno;

	public Aluno(String nome, Veiculo veiculo, double ra, Turno turno) {
		super(nome, veiculo);
		this.ra = ra;
		this.turno = turno;
	}

	public double getRa() {
		return ra;
	}

	public Turno getTurno() {
		return turno;
	}

}
