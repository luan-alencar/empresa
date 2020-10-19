package david.augusto.luan.interfaces;

import java.util.ArrayList;
import java.util.List;

import david.augusto.luan.entidades.Funcionario;
import david.augusto.luan.exceptions.FuncionarioNaoEncontrado;

public interface BuscarFuncionario {
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	default Funcionario buscarFuncionario(String cpf) throws FuncionarioNaoEncontrado {
		Funcionario funcionario = null;
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(cpf)) {
				funcionario = f;
			}
			throw new FuncionarioNaoEncontrado();
		}
		return funcionario;
	}

}
