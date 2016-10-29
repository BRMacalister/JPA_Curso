package com.dextratraining.banco;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.dextratraing.jpa.EntityManagerUtil;

public class BancoTest {
	
	@After
	public  void close(){
		EntityManagerUtil.fechar();
	}
	
	@Test
	public void salvarBancoTest() {
		BancoService bancoService = new BancoService();

		Banco bancoDoBrasil = new Banco();
		bancoDoBrasil.setNome("Bradesco");

		Banco bancoBradesco = new Banco();
		bancoBradesco.setNome("Banco do Brasil");

		bancoService.salvar(bancoDoBrasil);
		bancoService.salvar(bancoBradesco);

		Assert.assertNotNull("Id do Bradesco não pode ser Nul", bancoBradesco.getId());
		Assert.assertNotNull("Id do Banco do Brasilnão pode ser Nul", bancoDoBrasil.getId());

	}
	
	public void buscarPorIdTeste(){
		BancoService bancoService = new BancoService();
		Banco bancoDoBrasil = new Banco();
		bancoDoBrasil.setNome("Banco do Brasil");
		
		bancoService.salvar(bancoDoBrasil);
		
		Banco banco = bancoService.buscarPorId(-1L);
		Banco bancoEncontrado = bancoService.buscarPorId(bancoDoBrasil.getId());
		
		Assert.assertNull(banco);
		Assert.assertNotNull(bancoEncontrado);
		Assert.assertEquals(bancoDoBrasil.getNome(), bancoEncontrado.getNome());
		
		
	}

}
