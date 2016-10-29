package com.dextratraining.Pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.dextratraing.jpa.EntityManagerUtil;
import com.dextratraining.pessoa.Pessoa;
import com.dextratraining.pessoa.PessoaService;

public class PessoaServiceTest {

	@After
	public  void close() {
		EntityManagerUtil.fechar();
	}

	@Test
	public void salvarPessoaServiceTest() throws ParseException {
		PessoaService pessoaService = new PessoaService();

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Nome da pessoa");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = dateFormat.parse("13/12/1982");
		pessoa.setDataNascimento(dataNascimento);

		pessoaService.salvar(pessoa);

		Assert.assertNotNull("Id da pessoa não pode ser Nul", pessoa.getId());

	}

	@Test
	public void buscarTodosTeste() {
		PessoaService pessoaService = new PessoaService();

		Pessoa pessoa = new Pessoa();
		pessoa.setDataNascimento(new Date());
		pessoa.setNome("Flavio");
		pessoaService.salvar(pessoa);

		List<Pessoa> pessoas = pessoaService.buscarTodos();
		Assert.assertEquals(1, pessoas.size());

	}
}
