package com.dextratraining.teste;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {

	private Calculadora calculadora = new Calculadora();

	@Test
	public void testarSoma() {

		Double resultado = calculadora.soma(5, 5);
		Assert.assertEquals(Double.valueOf(10), resultado);

	}

	@Test
	public void testarsubtracao() {

		Double resultado = calculadora.subtratrair(5, 5);
		Assert.assertEquals(Double.valueOf(0), resultado);

	}

	@Test
	public void testarmultiplicacao() {

		Double resultado = calculadora.multiplicacao(5, 5);
		Assert.assertEquals(Double.valueOf(25), resultado);

	}

	@Test
	public void testardivisao() {

		Double resultado = calculadora.divisao(5, 5);
		Assert.assertEquals(Double.valueOf(1), resultado);

	}
}
