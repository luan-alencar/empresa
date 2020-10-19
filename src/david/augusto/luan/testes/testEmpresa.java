package david.augusto.luan.testes;

import david.augusto.luan.entidades.Empresa;
import david.augusto.luan.entidades.FuncionarioHorista;
import david.augusto.luan.exceptions.CpfJaExisteException;

public class testEmpresa {

	public static void main(String[] args) throws CpfJaExisteException {
		Empresa e = new Empresa("Accenture");
		FuncionarioHorista f = new FuncionarioHorista("12341234", "Fulando", 12.60, 200);
		e.contratar(f);
//		System.out.println(e.);
	}

}
