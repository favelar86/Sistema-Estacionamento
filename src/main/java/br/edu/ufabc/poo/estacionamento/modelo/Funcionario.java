package br.edu.ufabc.poo.estacionamento.modelo;

import java.text.SimpleDateFormat;

public class Funcionario extends Usuario {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private String registro;
	private int numeroVaga;
	private String entrada;
	private String saida;

	public Funcionario(String nome, Veiculo veiculo, String registro) {
		super(nome, veiculo);
		this.registro = registro;
	}

	public String getRegistro() {
		return registro;
	}

	public int getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}
	
	@Override
	public String toString() {
		
		if(dataEntrada != null) {
			entrada = sdf.format(dataEntrada);
		}
		
		if(dataSaida != null) {
			saida = sdf.format(dataSaida);
		}
		
		return "Funcionário: Id = " + id + "\n" +
				"Nome = " + nome +   "\n" +
				"Registro = " + registro + "\n" + 
				"Vaga = " + numeroVaga + "\n" +
				"Telefone = " + telefone + "\n" +
				"Veiculo = " + veiculo + "\n" +
				"Entrada = " + entrada + "\n" +
				"Saída = " + saida;
	}

}
