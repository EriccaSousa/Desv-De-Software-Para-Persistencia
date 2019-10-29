package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private int id;
	private String nome;
	private String endereco;
	private String sexo;
	private String dataAniversario;
	private double salario;
	private List<Dependente> dependentes;
	private Departamento departamento;

	public Funcionario() {
		super();

	}

	public Funcionario(String nome, String endereco, String sexo, String dataAniversario, double salario,
			Departamento departamento) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.dataAniversario = dataAniversario;
		this.salario = salario;
		this.departamento = departamento;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	@Override
	public String toString() {
		return "\nFuncionario\nId: " + this.id + "Nome: " + this.nome + "\nEndereco: " + this.endereco + "\nSexo: "
				+ this.sexo + "\nData Aniversario: " + this.dataAniversario + "Salario: " + this.salario + "\n";
	}

}
