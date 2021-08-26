package br.edu.ufabc.poo.estacionamento.modelo;

import br.edu.ufabc.poo.estacionamento.modelo.enums.TipoVeiculo;

public class Veiculo {
	
	private String placa;
	private TipoVeiculo tipoVeiculo;
	private String modelo;
	
	public Veiculo(String placa, TipoVeiculo tipoVeiculo) {
		this.placa = placa;
		this.tipoVeiculo = tipoVeiculo;
	}

	public Veiculo(String placa, TipoVeiculo tipoVeiculo, String modelo) {
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

	@Override
	public String toString() {
		return "placa= " + placa + ", tipoVeiculo= " + tipoVeiculo + ", modelo= " + modelo;
	}
	
}
