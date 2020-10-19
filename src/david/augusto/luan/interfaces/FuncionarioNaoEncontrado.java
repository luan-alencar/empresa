package david.augusto.luan.interfaces;

public class FuncionarioNaoEncontrado extends Exception {
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontrado() {
		super("Funcionario nao encontrado");
	}
}
