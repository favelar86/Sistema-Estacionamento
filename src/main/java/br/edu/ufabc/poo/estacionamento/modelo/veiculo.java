package br.edu.ufabc.poo.estacionamento.modelo;
import br.edu.ufabc.poo.estacionamento.enums.TipoVeiculo;

public class veiculo {
	
	private String placa;
	private TipoVeiculo tipoVeiculo;
	private String modelo;
	
	public veiculo(String placa) {
		this.placa = placa;
	}

	public veiculo(String placa, TipoVeiculo tipoVeiculo, String modelo) {
		this.placa = placa;
		this.tipoVeiculo = tipoVeiculo;
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public String getModelo() {
		return modelo;
	}
	
}
