package controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PesquisadorDAO;
import dao.PesquisadorJPA_DAO;
import model.Pesquisador;

public class PesquisadorCRUD {

	static Scanner read = new Scanner(System.in);

	public static void findAll() {
		PesquisadorDAO pesquisadorDAO = new PesquisadorJPA_DAO();

		List<Pesquisador> pesquisadores = pesquisadorDAO.findAll();
		pesquisadorDAO.close();

		for (Pesquisador pesquisador : pesquisadores) {
			System.out.println(pesquisador);
		}
		System.out.println("===========================================");
	}

	public static Pesquisador findByNome() {
		Pesquisador pesquisadorTemp = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		System.out.println("Informe o nome: ");
		String nome = read.nextLine();

		try {
			pesquisadorTemp = (Pesquisador) em.createQuery("SELECT p FROM Pesquisador p WHERE p.nome LIKE :nome")
					.setParameter("nome", nome + "%").getSingleResult();
		} catch (Exception e) {
			System.out.println("Erro!");
			e.printStackTrace();
		}

		return pesquisadorTemp;
	}

}
