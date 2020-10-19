package david.augusto.luan.exceptions;

public class CpfJaExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public CpfJaExisteException() {
		super("Funcionario ja existe");
	}

}
