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
	
	public String entradaManual(String nome, String cpf, Predios predio, Veiculo carro) {
		
		if(buscarUsuario(nome) != null) {
			
			return "Entrada não Liberada: Usuário já possuí cadastro";
		}
		
		Visitante visitante = new Visitante(nome, cpf, predio, carro);
		visitante.Entrar();
		this.usuarios.add(visitante);
		
		String retorno = buscaVaga(carro);
		return "Entrada Liberada " + retorno;	
	}
	
	public String entradaAutomatica(String nome) {
		
		try {		
			Usuario usuario = buscarUsuario(nome);

			String retorno = "";

			usuario.Entrar();
			
			if(usuario instanceof Funcionario) {
				
				if(((Funcionario) usuario).getNumeroVaga() != 0) {
					vagasReservadas++;
				}
				else {
					retorno = buscaVaga(usuario.getVeiculo());
				}
				
				return "Entrada liberada tipo funcionário " + retorno;
			}
			else if(usuario instanceof Aluno){	
				
				retorno = buscaVaga(usuario.getVeiculo());
				
				return "Entrada liberda tipo aluno " + retorno;
			}
			else {
				
				return "Usuário não cadastrado";
			}
			
		} catch(NullPointerException e) {
			return "Cliente inexistente! \n";	
		}
		
	}
	
	public String saida(String nome, String estacionamento) {
		
		try {	
			Usuario usuario = buscarUsuario(nome);
			usuario.Sair();
			
			if(estacionamento.equals("A")) {
				this.vagasCarroA--;
			}
			else if(estacionamento.equals("B")) {
				this.vagasCarroB--;
			}
			else if(estacionamento.equals("C")) {
				this.vagasCarroC--;
			}
			else if(estacionamento.equals("M")) {
				this.vagasMoto--;
			}
			else if(estacionamento.equals("R")) {
				this.vagasReservadas--;
			}
			
			return "Usuário " + usuario.getNome() + " deixou o estacionamento";
			
		} catch(NullPointerException e) {
			
			return "Cliente inexistente! \n";	
		}
		
	}
	
	public Usuario buscarUsuario(String nome) {
		Usuario usuario = usuarios.stream().filter(x -> x.getNome().equals(nome)).findFirst().orElse(null);
		
		return usuario;
	}
	
	public String buscaVaga(Veiculo veiculo) {
		
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
	
	public String estatisticasEstacionamento() {
		
		int vagasA = 500 - this.vagasCarroA;
		int vagasB = 500 - this.vagasCarroB;
		int vagasC = 500 - this.vagasCarroC;
		int vagasM = 100 - this.vagasMoto;
		
		return "Estatísticas \n" + 
		       "------------ \n" +
			   "Vagas estacionamento A    = " + vagasA + "\n" +
			   "Vagas estacionamento B    = " + vagasB + "\n" +
			   "Vagas estacionamento C    = " + vagasC + "\n" +
			   "Vagas estacionamento Moto = " + vagasM + "\n" +
			   "Vagas reservadas = " + this.vagasReservadas;
	}
	
	public String listar() {
		
		String mostraInfo = "";
		
		for(Usuario usuario : usuarios) {
			try {
				
				mostraInfo += "Id:   " + usuario.getId() + " | ";
				mostraInfo += "Nome: " + usuario.getNome() + " | ";
				mostraInfo += "Telefone: " + usuario.getTelefone() + " | ";
				mostraInfo += "Veículo: " + usuario.getVeiculo() + " | ";
				mostraInfo += "DataEntrada: "  + usuario.getDataEntrada() + " | ";
				mostraInfo += "DataSaída: "  + usuario.getDataSaida() + " | \n";
				
			} catch(NullPointerException e) {
				System.out.println("Cliente inexistente! \n");
			}
		}
		
		return mostraInfo;
	}
	
}
