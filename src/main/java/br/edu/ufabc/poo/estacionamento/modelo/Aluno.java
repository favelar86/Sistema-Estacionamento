package br.edu.ufabc.poo.estacionamento.modelo;

import br.edu.ufabc.poo.estacionamento.enums.Turno;

public class Aluno extends Usuario {
	
	private String ra;
	private Turno turno;

	public Aluno(String nome, Veiculo veiculo, String ra, Turno turno) {
		super(nome, veiculo);
		this.ra = ra;
		this.turno = turno;
	}

	public String getRa() {
		return ra;
	}

	public Turno getTurno() {
		return turno;
	}

	@Override
	public String toString() {
		return "Aluno: Id = " + id + "\n" +
				"Nome = " + nome +   "\n" +
				"RA = " + ra + "\n" + 
				"Turno = " + turno + "\n" +
				"Telefone = " + telefone + "\n" +
				"Veiculo = " + veiculo;
	}

}
