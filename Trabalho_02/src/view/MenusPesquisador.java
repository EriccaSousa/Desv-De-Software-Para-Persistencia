package view;

import java.util.Scanner;

import controller.FuncionarioCRUD;

public class MenusPesquisador {
	static Scanner read = new Scanner(System.in);
	static int opcao;

	public static void menuInicialByPesquisador() {
		do {
			System.out.println("Menu Pesquisador:");
			System.out.println(
					"[ 1 ] Cadastra Pesquisador\n[ 2 ] Buscar Pesquisador \n[ 3 ] Deletar Pesquisador \n[ 4 ] Voltar ");
			System.out.print("Escolha uma opção: ");
			opcao = read.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Aqui!");
				FuncionarioCRUD.criarPesquisador();
				break;
			case 2:
				menuBuscarByPesquisador();
				break;
			case 3:
				menuDeletarByPesquisador();
				break;
			case 4:
				MenusIniciais.menuFuncionarios();
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (true);
	}

	public static void menuBuscarByPesquisador() {
		do {
			System.out.println("Menu Pesquisar Pesquisador:");
			System.out.println(
					"[ 1 ] Listar todos os Pesquisador\n[ 2 ] Buscar Pesquisador por nome\n[ 3 ] Buscar Pesquisadorpor número de identificação\n[ 4 ] Voltar ");
			System.out.print("Escolha uma opção: ");
			opcao = read.nextInt();

			switch (opcao) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				menuInicialByPesquisador();
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (true);
	}

	public static void menuDeletarByPesquisador() {
		do {
			System.out.println("Menu Deletar Pesquisador:");
			System.out.println(
					"[ 1 ] Deletar Pesquisador por nome\n[ 2 ] Deletar Pesquisador por número de identificação\n[ 3 ] Voltar ");
			System.out.print("Escolha uma opção: ");
			opcao = read.nextInt();

			switch (opcao) {
			case 1:

				break;
			case 2:

				break;
			case 3:
				menuInicialByPesquisador();
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (true);
	}
}
