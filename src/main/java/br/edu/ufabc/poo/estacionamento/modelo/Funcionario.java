package br.edu.ufabc.poo.estacionamento.modelo;

public class Funcionario extends Usuario {
	
	private String registro;
	private int numeroVaga;

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
		return "Funcionário: Id = " + id + "\n" +
				"Nome = " + nome +   "\n" +
				"Registro = " + registro + "\n" + 
				"Vaga = " + numeroVaga + "\n" +
				"Telefone = " + telefone + "\n" +
				"Veiculo = " + veiculo;
	}

}
