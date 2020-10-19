package david.augusto.luan.interfaces;

import java.util.ArrayList;
import java.util.List;

import david.augusto.luan.entidades.Funcionario;
import david.augusto.luan.exceptions.CpfJaExisteException;

public interface ContratarFuncionario {
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	default void contratar(Funcionario funcionario) throws CpfJaExisteException {
		for (Funcionario f : funcionarios) {
			if (funcionario.getCpf().equals(f.getCpf())) {
				throw new CpfJaExisteException();
			}
		}
		funcionarios.add(funcionario);
	}
}