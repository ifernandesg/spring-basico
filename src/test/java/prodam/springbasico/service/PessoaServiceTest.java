package prodam.springbasico.service;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import prodam.springbasico.model.Pessoa;
import prodam.springbasico.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaServiceTest {
	
	@Autowired
	private PessoaService pessoaService;
	private static final String nome = "Teste";
	private static final String sobrenome = "Teste";
	private static final String empresa = "Teste";
	private static final String testeupdate = "TesteUpdate";
	
	@Test
	public void testCreatePessoa() throws Exception {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Teste");
		pessoa.setSobrenome("Teste");
		pessoa.setEmpresa("Teste");
		this.pessoaService.salvar(pessoa);
		
		assertEquals(nome, pessoa.getNome());
		assertEquals(sobrenome, pessoa.getSobrenome());
		assertEquals(empresa, pessoa.getEmpresa());
	}
	
	@Test
	public void testGetPessoaPorId() {
		Pessoa pessoa = this.pessoaService.getPessoaPorId(1L);
		
		assertEquals(nome, pessoa.getNome());
		assertEquals(sobrenome, pessoa.getSobrenome());
		assertEquals(empresa, pessoa.getEmpresa());
	}
		
	@Test
	public void testUpdatePessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Teste");
		pessoa.setSobrenome("Teste");
		pessoa .setEmpresa("Teste");
		this.pessoaService.salvar(pessoa);
		pessoa.setId(1L);
		pessoa.setNome("TesteUpdate");
		pessoa.setSobrenome("TesteUpdate");
		pessoa.setEmpresa("TesteUpdate");
		this.pessoaService.salvar(pessoa);
		
		assertEquals(testeupdate, pessoa.getNome());
		assertEquals(testeupdate, pessoa.getSobrenome());
		assertEquals(testeupdate, pessoa.getEmpresa());
	}
	
	@Test
	public void testDeletePorId() {
		Pessoa pessoaDelete = new Pessoa();
		pessoaDelete.setId(2L);
		pessoaDelete.setNome("Teste");
		pessoaDelete.setSobrenome("Teste");
		pessoaDelete.setEmpresa("Teste");
		this.pessoaService.salvar(pessoaDelete);
		this.pessoaService.deletePessoaPorId(2L);;
	}
}