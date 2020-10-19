package david.augusto.luan.entidades;

// um funcionario cm contrato a consolidação das leis do trabalho (CLT) , 
// ou carteira assinada, possui um salario fixo.
public class FuncionarioCLT extends Funcionario {
	private double salario;

	public FuncionarioCLT(String cpf, String nome, double salario) {
		super(cpf, nome);
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
