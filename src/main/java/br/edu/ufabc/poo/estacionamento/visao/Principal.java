package br.edu.ufabc.poo.estacionamento.visao;

import java.util.Scanner;

import br.edu.ufabc.poo.estacionamento.controle.ControleEstacionamento;
import br.edu.ufabc.poo.estacionamento.enums.Predios;
import br.edu.ufabc.poo.estacionamento.enums.TipoVeiculo;
import br.edu.ufabc.poo.estacionamento.enums.Turno;
import br.edu.ufabc.poo.estacionamento.modelo.Aluno;
import br.edu.ufabc.poo.estacionamento.modelo.Funcionario;
import br.edu.ufabc.poo.estacionamento.modelo.Usuario;
import br.edu.ufabc.poo.estacionamento.modelo.Veiculo;
import br.edu.ufabc.poo.estacionamento.modelo.Visitante;

public class Principal {
	
	private static ControleEstacionamento controleEstacionameto;
	private static Scanner entrada;

	public static void main(String[] args) {
		
		controleEstacionameto = new ControleEstacionamento();
		entrada = new Scanner(System.in);
		
		int opcao = -1;
		
		while (opcao !=0) {
			
			opcao = menu();

			switch (opcao) {
				case 1: {					
					adicionarAluno();	
					break;
				}
				case 2:{
					adicionarFuncionario();	
					break;
				}
				case 3: {					
					buscarContato();				
					break;
				}
				case 4: {
					removerUsuario();
					break;
				}
				case 5: {
					entradaManual();
					break;
				}
				case 6:{
					entradaAutomatica();
					break;
				}
				case 0: {
					System.out.println("Encerrando Sistema...");
					System.exit(opcao);
				}
				default:{
					System.out.println("Opção " + opcao + " inválida.");
					break;
				}
			}
		}
	}
	
	private static int menu() {
		
		System.out.println("\n");
		System.out.println("Digite uma opção:");
		System.out.println("1 - Adicionar Aluno");
		System.out.println("2 - Adicionar Funcionário");
		System.out.println("3 - Buscar Usuário");
		System.out.println("4 - Remover Usuário");
		System.out.println("5 - Entrada Manual");
		System.out.println("6 - Entrada Automática");
		System.out.println("0 - Sair");
		System.out.println("----------------");

		return Integer.parseInt(entrada.nextLine());
	}
	
	public static void adicionarAluno() {
		
		System.out.println("Digite o nome:");
		String nome = entrada.nextLine();
		
		System.out.println("Digite o telefone:");
		String telefone = entrada.nextLine();
		
		System.out.println("Digite o RA:");
		String ra = entrada.nextLine();

		System.out.println("Digite o turno 1 - Manhã, 2 - Tarde, 3 - Noite:");
		int valor = entrada.nextInt();
		
		Turno turno = Turno.Noite;
		if(valor == 1) {
			turno = Turno.Manha;
		}
		else if(valor == 2) {
			turno = Turno.Tarde;
		}
		else if(valor == 3) {
			turno = Turno.Noite;
		}
		
		Veiculo veiculo = cadastrarVeiculo();
		
		Aluno aluno = controleEstacionameto.adicionarAluno(nome, veiculo, ra, turno);
		aluno.setTelefone(telefone);

		System.out.println("----------------");
		System.out.println("Contato Cadastrado com Sucesso");
		System.out.println(aluno.toString());

	}
	
	public static void adicionarFuncionario() {
		
		System.out.println("Digite o nome:");
		String nome = entrada.nextLine();
		
		System.out.println("Digite o telefone:");
		String telefone = entrada.nextLine();
		
		System.out.println("Digite o Registro:");
		String registro = entrada.nextLine();
		
		System.out.println("Digite o número da vaga ou zero se não houver:");
		int vaga = entrada.nextInt();
		
		Veiculo veiculo = cadastrarVeiculo();
		
		Funcionario funcionario = controleEstacionameto.adicionarFuncionario(nome, veiculo, registro);
		funcionario.setTelefone(telefone);
		funcionario.setNumeroVaga(vaga);

		System.out.println("----------------");
		System.out.println("Contato Cadastrado com Sucesso");
		System.out.println(funcionario.toString());
	}
	
	public static void buscarContato() {
		
		System.out.print("Digite o Nome do usuário: ");
		String nome = entrada.nextLine();
		
		Usuario usuario = controleEstacionameto.buscarUsuario(nome);
		
		if(usuario == null) {
			System.out.println();
			System.out.print("Esse Contato não existe!");
		}
		else {
			System.out.println();
			System.out.println(usuario);
		}
	}
	
	public static Veiculo cadastrarVeiculo() {
		
		System.out.println("Digite dados do veículo:");
		entrada.nextLine();
		
		System.out.print("Digite a placa: ");
		String placa = entrada.nextLine();
		
		System.out.print("Digite o tipo de veículo 1 - Moto, 2 - Carro: ");
		int valor = entrada.nextInt();
		entrada.nextLine();
		
		TipoVeiculo tipoVeiculo = TipoVeiculo.Carro;
		
		if(valor == 1) {
			tipoVeiculo = TipoVeiculo.Moto;
		}
		else if(valor == 2) {
			tipoVeiculo = TipoVeiculo.Carro;
		}
		
		System.out.print("Digite o modelo do veículo: ");
		String modelo = entrada.nextLine();
		
		Veiculo veiculo = new Veiculo(placa, tipoVeiculo, modelo);
		
		return veiculo;
	}
	
	public static void removerUsuario() {
		
		System.out.print("Digite o Nome do usuário a ser removido: ");
		String nome = entrada.nextLine();
		
		controleEstacionameto.removerUsuario(nome);	
	}
	
	public static void entradaManual() {
		
		System.out.println("Digite o nome:");
		String nome = entrada.nextLine();
		
		System.out.println("Digite o CPF:");
		String cpf = entrada.nextLine();

		System.out.println("Digite o número do prédio");
		System.out.println(" 1 = BlocoA \n 2 = BlocoB \n 3 = Biblioteca \n 4 = Restaurante" +
				           "\n 5 = Poliesportivo \n 6 = BlocoI \n 7 = BlocoL");
		int valor = entrada.nextInt();
		
		Predios predio = Predios.BlocoA;
		if(valor == 1) {
			predio = Predios.BlocoA;
		}
		else if(valor == 2) {
			predio = Predios.BlocoB;
		}
		else if(valor == 3) {
			predio = Predios.Biblioteca;
		}
		else if(valor == 4) {
			predio = Predios.Restaurante;
		}
		else if(valor == 5) {
			predio = Predios.Poliesportivo;
		}
		else if(valor == 6) {
			predio = Predios.BlocoI;
		}
		else if(valor == 7) {
			predio = Predios.BlocoL;
		}
		
		Veiculo veiculo = cadastrarVeiculo();
		
		String visitante = controleEstacionameto.EntradaManual(nome, cpf, predio, veiculo);

		System.out.println("----------------");
		System.out.println(visitante);
	}
	
	public static void entradaAutomatica() {
		
		System.out.println("Digite o nome:");
		String nome = entrada.nextLine();
		
		String usuario = controleEstacionameto.EntradaAutomatica(nome);
		
		System.out.println("----------------");
		System.out.println(usuario);
	}

}
