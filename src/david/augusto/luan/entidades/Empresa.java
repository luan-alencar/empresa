package david.augusto.luan.entidades;

import java.util.ArrayList;
import java.util.List;

import david.augusto.luan.interfaces.BuscarFuncionario;
import david.augusto.luan.interfaces.CalcularSalario;
import david.augusto.luan.interfaces.ContratarFuncionario;
import david.augusto.luan.interfaces.DemitirFuncionario;

public class Empresa implements ContratarFuncionario, DemitirFuncionario, 
	CalcularSalario, BuscarFuncionario {

	private String nome;
	private List<Funcionario> funcionarios;

	public Empresa(String nome) {
		this.nome = nome;
		this.funcionarios = new ArrayList<Funcionario>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
