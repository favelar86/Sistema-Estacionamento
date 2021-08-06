package br.edu.ufabc.poo.estacionamento;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ufabc.poo.estacionamento.controle.ControleEstacionamento;
import br.edu.ufabc.poo.estacionamento.enums.Predios;
import br.edu.ufabc.poo.estacionamento.enums.TipoVeiculo;
import br.edu.ufabc.poo.estacionamento.enums.Turno;
import br.edu.ufabc.poo.estacionamento.modelo.Usuario;
import br.edu.ufabc.poo.estacionamento.modelo.Veiculo;

public class ControleEstacionamentoTest {
	
	private static ControleEstacionamento controleEstacionamento;
	private Veiculo carro;
	
	@Before
	public void inicializaUsuarios(){
		
		controleEstacionamento = new ControleEstacionamento();
		carro = new Veiculo("ABCD- 1234", TipoVeiculo.Carro, "Corsa");
	}
	
	@Test
	public void entradaManualTest() {
		
		String retorno = controleEstacionamento.entradaManual("Visitante", "111.222.333.444-55", Predios.BlocoA, carro);

		assertEquals("Entrada Liberada Vagas Carro A", retorno);
		
		controleEstacionamento.adicionarAluno("Aluno", carro, "11111111", Turno.Noite);
		retorno = controleEstacionamento.entradaManual("Aluno", "111.222.333.444-55", Predios.BlocoA, carro);
		
		assertEquals("Entrada não Liberada: Usuário já possuí cadastro", retorno);
	}
	
	
	@Test
	public void entradaAutomaticaTest() {
		
		controleEstacionamento.adicionarAluno("Aluno", carro, "11111111", Turno.Noite);
		String retorno = controleEstacionamento.entradaAutomatica("Aluno");
		
		assertEquals("Entrada liberda tipo aluno Vagas Carro A", retorno);
	}
	
	
	@Test
	public void entradaAutomaticaExcecaoTest() {
		
		try {
			
			controleEstacionamento.entradaAutomatica("Aluno");
		}
		catch(NullPointerException e){
			
			assertEquals("Saldo Insuficiente",  e.getMessage());
		}
	}
	
	
	@Test
	public void saidaTest() {
		
		controleEstacionamento.adicionarAluno("Aluno", carro, "11111111", Turno.Noite);
		String retorno = controleEstacionamento.saida("Aluno", "A");
		
		assertEquals("Usuário Aluno deixou o estacionamento", retorno);
	}
	
	
	@Test
	public void saidaExcecaoTest() {
		
		try {
			
			controleEstacionamento.saida("Aluno", "A");
		}
		catch(NullPointerException e){
			
			assertEquals("Cliente inexistente! \n",  e.getMessage());
		}
	}
	
	
	@Test
	public void buscarTest() {
		
		controleEstacionamento.adicionarAluno("Aluno", carro, "11111111", Turno.Noite);
		Usuario usuario = controleEstacionamento.buscarUsuario("Aluno");
		
		assertEquals("Aluno: Id = 5" + "\n" +
				     "Nome = Aluno" + "\n" +
				     "RA = 11111111" + "\n" + 
				     "Turno = Noite" + "\n" +
				     "Telefone = null" + "\n" +
				     "Veiculo = placa=ABCD- 1234, tipoVeiculo=Carro, modelo=Corsa" + "\n" +
				     "Entrada = null" + "\n" +
				     "Saída = null", usuario.toString());
	}
	
	@Test
	public void buscaVagaTest() {
		
		String retorno = controleEstacionamento.buscaVaga(carro);
		
		assertEquals("Vagas Carro A", retorno);
	}
	
	@Test
	public void adicionarAlunoTest() {
		
		Usuario aluno = controleEstacionamento.adicionarAluno("Aluno2", carro, "22222222", Turno.Manha);
		
		assertEquals("Aluno: Id = 8" + "\n" +
				     "Nome = Aluno2" + "\n" +
				     "RA = 22222222" + "\n" + 
				     "Turno = Manha" + "\n" +
				     "Telefone = null" + "\n" +
				     "Veiculo = placa=ABCD- 1234, tipoVeiculo=Carro, modelo=Corsa" + "\n" +
				     "Entrada = null" + "\n" +
				     "Saída = null", aluno.toString());
	}

	@Test
	public void adicionarFuncionarioTest() {
		
		Usuario usuario = controleEstacionamento.adicionarFuncionario("Funcionário", carro, "12345678");
		
		assertEquals("Funcionário: Id = 1" + "\n" +
				     "Nome = Funcionário" + "\n" +
				     "Registro = 12345678" + "\n" + 
				     "Vaga = 0" + "\n" +
				     "Telefone = null" + "\n" +
				     "Veiculo = placa=ABCD- 1234, tipoVeiculo=Carro, modelo=Corsa" + "\n" +
				     "Entrada = null" + "\n" +
				     "Saída = null", usuario.toString());
	}
	
	@Test
	public void removerUsuarioTest() {
		
		controleEstacionamento.adicionarAluno("Remover", carro, "22222222", Turno.Manha);
		
		assertTrue(controleEstacionamento.removerUsuario("Remover"));
		assertFalse(controleEstacionamento.removerUsuario("Remover"));
	}
	
	@Test
	public void estatisticasEstacionamentoTest() {
		
		String retorno = controleEstacionamento.estatisticasEstacionamento();
		
		assertEquals("Estatísticas " + "\n" +
				     "------------ " + "\n" +
				     "Vagas estacionamento A    = 500" + "\n" +
				     "Vagas estacionamento B    = 500" + "\n" +
				     "Vagas estacionamento C    = 500" + "\n" +
				     "Vagas estacionamento Moto = 100" + "\n" +
				     "Vagas reservadas = 0", retorno);
	}
	
	@Test
	public void listarTest() {
		
		controleEstacionamento.adicionarAluno("Aluno", carro, "22222222", Turno.Manha);
		controleEstacionamento.adicionarFuncionario("Funcionário", carro, "12345678");
		
		String retorno = controleEstacionamento.listar();
		
		assertEquals("Id:   6 | Nome: Aluno | Telefone: null | Veículo: placa=ABCD- 1234, tipoVeiculo=Carro, modelo=Corsa | DataEntrada: null | DataSaída: null | " + "\n" + 
				     "Id:   7 | Nome: Funcionário | Telefone: null | Veículo: placa=ABCD- 1234, tipoVeiculo=Carro, modelo=Corsa | DataEntrada: null | DataSaída: null | " + "\n" 
				     , retorno);
	}
	
}
