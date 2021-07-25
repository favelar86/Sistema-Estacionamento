package br.edu.ufabc.poo.estacionamento.controle;

import java.util.ArrayList;

import br.edu.ufabc.poo.estacionamento.enums.Predios;
import br.edu.ufabc.poo.estacionamento.enums.TipoVeiculo;
import br.edu.ufabc.poo.estacionamento.modelo.Usuario;
import br.edu.ufabc.poo.estacionamento.modelo.Veiculo;
import br.edu.ufabc.poo.estacionamento.modelo.Visitante; 

public class ControleEstacionamento {
	
	private int vagasCarroA;
	private int vagasCarroB;
	private int vagasCarroC;
	private int vagasMoto;
	private int vagasReservadas;
	private ArrayList<Usuario> usuarios;
	
	public ControleEstacionamento() {
		
		usuarios = new ArrayList<Usuario>();
		this.vagasCarroA = 0;
		this.vagasCarroB = 0;
		this.vagasCarroC = 0;
		this.vagasMoto = 0;
		this.vagasReservadas = 0;
	}
	
	public String EntradaManual(String nome, String cpf, Predios predio, Veiculo carro) {
		
		if(buscarUsuario(nome) != null) {
			
			return "Entrada não Liberada: Usuário já possuí cadastro";
		}
		
		Visitante visitante = new Visitante(nome, cpf, predio, carro);
		this.usuarios.add(visitante);
		
		String retorno = BuscaVaga(carro);
		return "Entrada Liberada" + retorno;	
	}
	
	public Usuario buscarUsuario(String nome) {
		Usuario usuario = usuarios.stream().filter(x -> x.getNome() == nome).findFirst().orElse(null);
		
		return usuario;
	}
	
	public String BuscaVaga(Veiculo veiculo) {
		
		String retorno = "";
		
		if(veiculo.getTipoVeiculo() == TipoVeiculo.Carro) {
			
			if(vagasCarroA < 500) {
				vagasCarroA++;
				retorno = "Vagas Carro A";
			}
			
			else if(vagasCarroB < 500) {
				vagasCarroB++;
				retorno = "Vagas Carro B";
			}
			
			else if(vagasCarroC < 500) {
				vagasCarroC++;
				retorno = "Vagas Carro C";
			}
			else {
				retorno = "Estacionamento Cheio - Aguarde uma vaga";
			}
		}
		else if(veiculo.getTipoVeiculo() == TipoVeiculo.Moto){
			
			if(vagasMoto < 100) {
				vagasMoto++;
				retorno = "Vagas Motos";
			}
			else {
				retorno = "Estacionamento Cheio - Aguarde uma vaga";
			}
		}
		
		return retorno;
	}
	
}
