package br.edu.ufabc.poo.estacionamento.visao;

import br.edu.ufabc.poo.estacionamento.controle.ControleEstacionamento;
import br.edu.ufabc.poo.estacionamento.enums.Predios;
import br.edu.ufabc.poo.estacionamento.enums.TipoVeiculo;
import br.edu.ufabc.poo.estacionamento.modelo.Veiculo;

public class Principal {

	public static void main(String[] args) {
		
		ControleEstacionamento ce = new ControleEstacionamento();
		Veiculo v1 = new Veiculo("ABCD-1234", TipoVeiculo.Carro);
		
//		ce.EntradaManual("Fabiano", "33537906838", Predios.BlocoA, v1);

		System.out.println(ce.EntradaManual("Fabiano", "33537906838", Predios.BlocoA, v1));

	}
}
