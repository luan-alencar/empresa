package david.augusto.luan.interfaces;

import david.augusto.luan.entidades.Funcionario;
import david.augusto.luan.exceptions.FuncionarioNaoEncontrado;

import java.util.ArrayList;
import java.util.List;

public interface DemitirFuncionario {
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	default void demitir(String cpf) throws FuncionarioNaoEncontrado {
		Funcionario funcionario = null;
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(cpf)) {
				throw new FuncionarioNaoEncontrado();
			}
			funcionario = f;
		}
		funcionarios.remove(funcionario);
	}
}
