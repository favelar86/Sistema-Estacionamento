package br.edu.ufabc.poo.estacionamento.modelo;

import java.text.SimpleDateFormat;

import br.edu.ufabc.poo.estacionamento.enums.Turno;

public class Aluno extends Usuario {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private String ra;
	private Turno turno;
	private String entrada;
	private String saida;

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
		
		if(dataEntrada != null) {
			entrada = sdf.format(dataEntrada);
		}
		
		if(dataSaida != null) {
			saida = sdf.format(dataSaida);
		}
		
		return "Aluno: Id = " + id + "\n" +
				"Nome = " + nome +   "\n" +
				"RA = " + ra + "\n" + 
				"Turno = " + turno + "\n" +
				"Telefone = " + telefone + "\n" +
				"Veiculo = " + veiculo + "\n" +
				"Entrada = " + entrada + "\n" +
				"Saída = " + saida;
	}

}
