package david.augusto.luan.interfaces;

import java.util.ArrayList;
import java.util.List;

import david.augusto.luan.entidades.Funcionario;
import david.augusto.luan.exceptions.FuncionarioNaoEncontrado;

public interface CalcularSalario {
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	default double calculaSalario(String cpf) throws FuncionarioNaoEncontrado {
		double salario = 0;
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(cpf)) {
				salario = f.getSalario();
			}
			throw new FuncionarioNaoEncontrado();
		}
		return salario;
	}
}
