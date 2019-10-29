package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "funcionario_id")
public class Secretario extends Funcionario {

	private String grauEscolaridade;

	public Secretario() {

	}

	public Secretario(String nome, String endereco, String sexo, String dataAniversario, double salario,
			String grauEscolar) {
		this(0, nome, endereco, sexo, dataAniversario, salario, grauEscolar);
	}

	public Secretario(int id, String nome, String endereco, String sexo, String dataAniversario, double salario,
			String grauEscolar) {
		super(id, nome, endereco, sexo, dataAniversario, salario);
		this.grauEscolaridade = grauEscolar;

	}

	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}

	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}

	@Override
	public String toString() {
		return "Função: Secretario" + "\nId: " + this.getId() + "\nNome: " + this.getNome() + "\nEndereço: "
				+ this.getEndereco() + "\nSexo: " + this.getSexo() + "\nData Aniversário: " + this.getDataAniversario()
				+ "\nSalário: " + this.getSalario() + "\ngrauEscolaridade: " + this.grauEscolaridade + "\n";
	}

}
