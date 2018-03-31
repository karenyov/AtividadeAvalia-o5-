package atividade;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * @author Karen 30 de mar de 2018
 */
public class ATeste {

	@Mock
	private A a = null;

	@Before
	public void setUp() throws Exception {
		/* o método mock cria um objeto do tipo Operacao */
		a = mock(A.class);
	}

	/**
	 * Exercício 1 – O Desenvolvimento Orientado a Testes (TDD) diz que os
	 * testes devem ser codificados antes dos artefatos serem implementados.
	 * Programar uma classe de testes de nome ATest para testar o método calc,
	 * da classe A, nas seguintes situações:
	 * 
	 */

	/**
	 * 
	 * {a: 2, b: 2, esperado: 4}
	 */
	@Test
	public void test1() throws Exception {
		when(a.calc(2, 2)).thenReturn(4);
	}

	/**
	 * 
	 * {a: “x”, b: “y”, esperado: “xy”}
	 */
	@Test
	public void test2() throws Exception {
		when(a.calc("x", "y")).thenReturn("xy");
	}

	/**
	 * 
	 * {a: null, b: “y”, esperado: NullPointerException}
	 */
	@Test(expected = NullPointerException.class)
	public void test3() throws Exception {
		when(a.calc(null, "y")).thenThrow(new NullPointerException());
		/*
		 * a chamada a seguir irá lançar uma exceção do tipo
		 * NullPointerException
		 */
		assertSame(1, a.calc(null, "y"));
	}

	/**
	 * 
	 * {a: “2”, b: 2, esperado: Exception}
	 */
	@Test(expected = Exception.class)
	public void test4() throws Exception {
		when(a.calc("2", 2)).thenThrow(new Exception());
		/* a chamada a seguir irá lançar uma exceção do tipo Exception */
		assertSame(1, a.calc("2", 2));
	}

	/**
	 * Exercício 2 – O método doThrow pode ser utilizado para testar métodos com
	 * retorno void. Adicionar na classe ATest um teste para o método msg, da
	 * classe A
	 * 
	 */
	@Test(expected = Exception.class)
	public void exerc02() throws Exception {
		doThrow(new Exception("Teste de exceção")).when(a).msg(null);

	}

	/**
	 * Exercício 3 – O método verify, do pacote org.mockito.Mockito.verify, é
	 * usado para checar a quantidade de vezes que um método é invocado.
	 * Adicionar na classe ATest um teste para checar se ao invocar o método
	 * area(2) o método pi() é invocado exatamente 1 vez.
	 * 
	 */
	@Test
	public void exerc03() throws Exception {

		when(a.area(2)).thenCallRealMethod();
		verify(a, times(1)).pi();

	}

	/**
	 * Exercício 4 – Adicionar na classe ATest um teste para checar se ao
	 * invocar o método pow() o método pi() é invocado exatamente 2 vez.
	 */
	@Test
	public void exerc04() throws Exception {
		verify(a, times(0)).pow();

		assertSame(0.0, a.pow());

		verify(a, times(1)).pi();

	}

	/**
	 * Exercício 5 – Adicionar na classe ATest o método a seguir e fazer as
	 * devidas alterações para que o resultado do teste seja “verde”, isto é,
	 * aprovado no teste
	 */
	@Test(expected = NullPointerException.class)
	public void incTest() {
		when(a.inc()).thenReturn(1, 2, 3, 4).thenThrow(new NullPointerException("Além do limite"));
		while (true) {
			System.out.println(a.inc());
		}
	}

}
