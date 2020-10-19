package david.augusto.luan.entidades;

import david.augusto.luan.interfaces.ContratarFuncionario;
import david.augusto.luan.interfaces.DemitirFuncionario;

public class Empresa implements ContratarFuncionario, DemitirFuncionario {

	private String nome;

	public Empresa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
