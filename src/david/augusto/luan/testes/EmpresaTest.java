package david.augusto.luan.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import david.augusto.luan.entidades.Empresa;
import david.augusto.luan.entidades.Funcionario;
import david.augusto.luan.entidades.FuncionarioCLT;
import david.augusto.luan.entidades.FuncionarioHorista;
import david.augusto.luan.exceptions.CpfJaExisteException;
import david.augusto.luan.exceptions.FuncionarioNaoEncontrado;

public class EmpresaTest {
	private Empresa empresa;

	@BeforeEach
	void setUp() throws Exception {
		empresa = new Empresa("Fábrica de Colchões");
		empresa.contratar(new FuncionarioCLT("000.000.000-00", "Operario 1", 2000.0));
		empresa.contratar(new FuncionarioCLT("111.111.111-11", "Operario 2", 2500.0));
		empresa.contratar(new FuncionarioCLT("222.222.222-22", "Gerente", 5000.0));
		empresa.contratar(new FuncionarioHorista("333.333.333-33", "Motorista", 18.75, 0));
		empresa.contratar(new FuncionarioHorista("444.444.444-44", "Zelador", 15.0, 0));
	}

	@Test
	void testContratarComSucesso() throws CpfJaExisteException {
		// Nesse caso, é para contratar o funcionário sem nenhum problema
		FuncionarioCLT diretor = new FuncionarioCLT("555.555.555-55", "Diretor", 8000.0);
		empresa.contratar(diretor);
		assertTrue(empresa.getFuncionarios().contains(diretor));
	}

	@Test
	void testContratarCpfRepetido() throws CpfJaExisteException {
		// Aqui eu espero que ocorra uma exceção de CPF repetido
		Exception ex = assertThrows(CpfJaExisteException.class, () -> {
			Funcionario diretor = new FuncionarioCLT("000.000.000-00", "Diretor", 8000.0);
			empresa.contratar(diretor);
		});
		assertNotNull(ex);
		assertEquals("Já existe um funcionário cadastrado com o CPF 000.000.000-00", ex.getMessage());
	}

	@Test
	void testGetFuncionarioQueExiste() throws FuncionarioNaoEncontrado {
		// Esse funcionário existe
		Funcionario f = empresa.buscarFuncionario("111.111.111-11");
		assertNotNull(f);
		assertEquals("Operario 2", f.getNome());
	}

	@Test
	void testGetFuncionarioQueNaoExiste() throws FuncionarioNaoEncontrado {
		// Tentando procurar um funcionário que não existe
		Exception ex = assertThrows(FuncionarioNaoEncontrado.class, () -> {
			empresa.buscarFuncionario("666.666.666-66");
		});
		assertNotNull(ex);
		assertEquals("Não foi encontrado um funcionário com o CPF 666.666.666-66", ex.getMessage());
	}

	@Test
	void testDemitirFuncionarioQueExiste() throws FuncionarioNaoEncontrado {
		Funcionario f = empresa.buscarFuncionario("111.111.111-11");
		assertNotNull(f);
		// Confirma que o funcionário existe mesmo
		assertTrue(empresa.getFuncionarios().contains(f));
		// Demite o funcionário
		empresa.demitir("111.111.111-11");
		// Confirma que o funcionário não consta mais na empresa
		assertFalse(empresa.getFuncionarios().contains(f));
	}

	@Test
	void testDemitirFuncionarioQueNaoExiste() throws FuncionarioNaoEncontrado {
		// Tentando demitir um funcionário que não existe
		Exception ex = assertThrows(FuncionarioNaoEncontrado.class, () -> {
			empresa.demitir("666.666.666-66");
		});
		assertEquals("Não foi encontrado um funcionário com o CPF 666.666.666-66", ex.getMessage());
	}
}