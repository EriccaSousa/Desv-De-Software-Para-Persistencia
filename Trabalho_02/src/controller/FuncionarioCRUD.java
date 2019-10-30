package controller;

import java.util.Scanner;

import javax.persistence.PersistenceException;

import dao.FuncionarioJPA_DAO;
import dao.FuncionarioLimpezaDAO;
import dao.FuncionarioLimpezaJPA_DAO;
import dao.PesquisadorDAO;
import dao.PesquisadorJPA_DAO;
import dao.SecretarioDAO;
import dao.SecretarioJPA_DAO;
import model.Departamento;
import model.Funcionario;
import model.FuncionarioLimpeza;
import model.Pesquisador;
import model.Projeto;
import model.Secretario;

public class FuncionarioCRUD {
	static Scanner read = new Scanner(System.in);

	public static Funcionario retornarFuncionario() {

		System.out.println("Informe os dados do Funcionario(a)\n");
		System.out.println("Nome: ");
		String nome = read.nextLine();
		System.out.println("Endereco: ");
		String endereco = read.nextLine();
		System.out.println("Sexo: ");
		String sexo = read.nextLine();
		System.out.println("Data Aniversario: ");
		String dataAniver = read.nextLine();
		System.out.println("Salario: ");
		double salario = read.nextDouble();
		read.nextLine();

		Departamento departamento = DepartamentoCRUD.findByNome();

		System.out.println(
				"Informe a funcao do seu Funcionário:\n[ 1 ] Funcionario de Limpeza\n[ 2 ] Secretario(a)\n[ 3 ] Pesquisador(a)");
		int opcao = read.nextInt();
		read.nextLine();

		if (opcao == 1) {
			System.out.println("Cargo:");
			String cargo = read.nextLine();
			System.out.println("Jornada de trabalho: ");
			String jornadaTrab = read.nextLine();

			FuncionarioLimpeza funcionarioLimpeza = new FuncionarioLimpeza(nome, endereco, sexo, dataAniver, salario,
					null, departamento, cargo, jornadaTrab);

			return funcionarioLimpeza;

		} else if (opcao == 2) {
			System.out.println("Grau de escolaridade: ");
			String grauEscolar = read.nextLine();

			Funcionario secretario = new Secretario(nome, endereco, sexo, dataAniver, salario, null, departamento,
					grauEscolar);

			return secretario;
		} else if (opcao == 3) {
			System.out.println("Área atuação: ");
			String areaAtuacao = read.nextLine();

			System.out.println("Informações do projeto em que irá trabalhara:");
			Projeto projeto = ProjetoCRUD.findByNome();

			Funcionario pesquisador = new Pesquisador(nome, endereco, sexo, dataAniver, salario, null, departamento,
					areaAtuacao, projeto);
			return pesquisador;
		} else {
			System.out.println("Opção inválida");

			return null;
		}

	}

	public static void criarSecretario() {
		SecretarioDAO secretarioDAO = new SecretarioJPA_DAO();
		try {
			secretarioDAO.beginTransaction();
			secretarioDAO.save(retornarFuncionario());
			secretarioDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			System.out.println("\nErro ao salvar Pesquisador!\n");

			secretarioDAO.rollback();
			e.printStackTrace();
		} finally {
			secretarioDAO.close();
		}
	}

	public static void criarPesquisador() {
		PesquisadorDAO pesquisadorDAO = new PesquisadorJPA_DAO();

		try {
			pesquisadorDAO.beginTransaction();
			pesquisadorDAO.save(retornarFuncionario());
			pesquisadorDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			System.out.println("\nErro ao salvar Pesquisador!\n");

			pesquisadorDAO.rollback();
			e.printStackTrace();
		} finally {
			pesquisadorDAO.close();
		}
	}

	public static void criarFuncLmpeza() {
		FuncionarioLimpezaDAO funcLimpezaDAO = new FuncionarioLimpezaJPA_DAO();

		try {
			funcLimpezaDAO.beginTransaction();
			funcLimpezaDAO.save(retornarFuncionario());
			funcLimpezaDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
			System.out.println("\nErro ao salvar Funcionario de Limpeza!\n");

			funcLimpezaDAO.rollback();
			e.printStackTrace();
		} finally {
			funcLimpezaDAO.close();
		}
	}

}
