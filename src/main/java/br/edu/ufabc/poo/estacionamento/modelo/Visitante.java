package br.edu.ufabc.poo.estacionamento.modelo;

import java.text.SimpleDateFormat;
import br.edu.ufabc.poo.estacionamento.modelo.enums.Predios;

public class Visitante extends Usuario {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private String cpf;
	private Predios predio;
	private String entrada;
	private String saida;
	

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
	
	@Override
	public String toString() {
		
		if(dataEntrada != null) {
			entrada = sdf.format(dataEntrada);
		}
		
		if(dataSaida != null) {
			saida = sdf.format(dataSaida);
		}
		
		return "Visitante: Id = " + id + "\n" +
				"Nome = " + nome +   "\n" +
				"CPF = " + cpf + "\n" + 
				"Prédio = " + predio + "\n" +
				"Veiculo = " + veiculo + "\n" +
				"Entrada = " + entrada + "\n" +
				"Saída = " + saida;
	}

}

