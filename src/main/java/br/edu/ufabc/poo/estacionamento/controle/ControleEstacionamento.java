package br.edu.ufabc.poo.estacionamento.controle;

import java.util.ArrayList;
import br.edu.ufabc.poo.estacionamento.enums.Predios;
import br.edu.ufabc.poo.estacionamento.enums.TipoVeiculo;
import br.edu.ufabc.poo.estacionamento.enums.Turno;
import br.edu.ufabc.poo.estacionamento.modelo.Funcionario;
import br.edu.ufabc.poo.estacionamento.modelo.Usuario;
import br.edu.ufabc.poo.estacionamento.modelo.Veiculo;
import br.edu.ufabc.poo.estacionamento.modelo.Visitante;
import br.edu.ufabc.poo.estacionamento.modelo.Aluno;

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
		visitante.Entrar();
		this.usuarios.add(visitante);
		
		String retorno = BuscaVaga(carro);
		return "Entrada Liberada " + retorno;	
	}
	
	public String EntradaAutomatica(String nome) {
		
		Usuario usuario = buscarUsuario(nome);
		String retorno = "";
		
		usuario.Entrar();
		
		if(usuario instanceof Funcionario) {
			
			if(((Funcionario) usuario).getNumeroVaga() !=0) {
				vagasReservadas++;
			}
			else {
				retorno = BuscaVaga(usuario.getVeiculo());
			}
			
			return "Entrada liberada tipo funcionário " + retorno;
		}
		else if(usuario instanceof Aluno){	
			
			retorno = BuscaVaga(usuario.getVeiculo());
			
			return "Entrada liberda tipo aluno " + retorno;
		}
		else {
			
			return "Usuário não cadastrado";
		}
		
	}
	
	public Usuario buscarUsuario(String nome) {
		Usuario usuario = usuarios.stream().filter(x -> x.getNome().equals(nome)).findFirst().orElse(null);
		
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
	
	public Aluno adicionarAluno(String nome, Veiculo veiculo, String ra, Turno turno) {
		Aluno aluno = new Aluno(nome, veiculo, ra, turno);
		this.usuarios.add(aluno);
		
		return aluno;
	}
	
	public Funcionario adicionarFuncionario(String nome, Veiculo veiculo, String registro) {
		Funcionario funcionario = new Funcionario(nome, veiculo, registro);
		this.usuarios.add(funcionario);
		
		return funcionario;
	}
	
	public boolean removerUsuario(String nome) {
		Usuario usuario = usuarios.stream().filter(x -> x.getNome().equals(nome)).findFirst().orElse(null);
		
		try {
			usuarios.remove(usuarios.indexOf(usuario));
			System.out.println("Usuário removido com sucessso!");
			
			return true;
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("\n");
			System.out.println("Esse Id não existe!");
			
			return false;
		}	
	}
	
}
