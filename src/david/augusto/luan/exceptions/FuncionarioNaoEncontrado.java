package david.augusto.luan.exceptions;

public class FuncionarioNaoEncontrado extends Exception {
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontrado() {
		super("Funcionario nao encontrado");
	}
}
