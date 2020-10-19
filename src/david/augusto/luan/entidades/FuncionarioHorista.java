package david.augusto.luan.entidades;

// um funcionario horista possui um contrato que estabelece um valor para a hora
// trabalhada - o salario sera calculado multiplicando o valor da hora
// pelo numero de horas trabalhadas

public class FuncionarioHorista extends Funcionario {
	private double valorHora;
	private int horasTrabalhadasNoMes;

	public FuncionarioHorista(String cpf, String nome, double valorHora, double horasTrabalhadasNoMes) {
		super(cpf, nome);
		this.valorHora = valorHora;
	}

	public void sethorasTrabalhadasNoMes(int horasTrabalhadasNoMes) {
		this.horasTrabalhadasNoMes = horasTrabalhadasNoMes;
	}

	public double getSalario() {
		return this.valorHora * horasTrabalhadasNoMes;
	}

}
