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
		/* o m�todo mock cria um objeto do tipo Operacao */
		a = mock(A.class);
	}

	/**
	 * Exerc�cio 1 � O Desenvolvimento Orientado a Testes (TDD) diz que os
	 * testes devem ser codificados antes dos artefatos serem implementados.
	 * Programar uma classe de testes de nome ATest para testar o m�todo calc,
	 * da classe A, nas seguintes situa��es:
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
	 * {a: �x�, b: �y�, esperado: �xy�}
	 */
	@Test
	public void test2() throws Exception {
		when(a.calc("x", "y")).thenReturn("xy");
	}

	/**
	 * 
	 * {a: null, b: �y�, esperado: NullPointerException}
	 */
	@Test(expected = NullPointerException.class)
	public void test3() throws Exception {
		when(a.calc(null, "y")).thenThrow(new NullPointerException());
		/*
		 * a chamada a seguir ir� lan�ar uma exce��o do tipo
		 * NullPointerException
		 */
		assertSame(1, a.calc(null, "y"));
	}

	/**
	 * 
	 * {a: �2�, b: 2, esperado: Exception}
	 */
	@Test(expected = Exception.class)
	public void test4() throws Exception {
		when(a.calc("2", 2)).thenThrow(new Exception());
		/* a chamada a seguir ir� lan�ar uma exce��o do tipo Exception */
		assertSame(1, a.calc("2", 2));
	}

	/**
	 * Exerc�cio 2 � O m�todo doThrow pode ser utilizado para testar m�todos com
	 * retorno void. Adicionar na classe ATest um teste para o m�todo msg, da
	 * classe A
	 * 
	 */
	@Test(expected = Exception.class)
	public void exerc02() throws Exception {
		doThrow(new Exception("Teste de exce��o")).when(a).msg(null);

	}

	/**
	 * Exerc�cio 3 � O m�todo verify, do pacote org.mockito.Mockito.verify, �
	 * usado para checar a quantidade de vezes que um m�todo � invocado.
	 * Adicionar na classe ATest um teste para checar se ao invocar o m�todo
	 * area(2) o m�todo pi() � invocado exatamente 1 vez.
	 * 
	 */
	@Test
	public void exerc03() throws Exception {

		when(a.area(2)).thenCallRealMethod();
		verify(a, times(1)).pi();

	}

	/**
	 * Exerc�cio 4 � Adicionar na classe ATest um teste para checar se ao
	 * invocar o m�todo pow() o m�todo pi() � invocado exatamente 2 vez.
	 */
	@Test
	public void exerc04() throws Exception {
		verify(a, times(0)).pow();

		assertSame(0.0, a.pow());

		verify(a, times(1)).pi();

	}

	/**
	 * Exerc�cio 5 � Adicionar na classe ATest o m�todo a seguir e fazer as
	 * devidas altera��es para que o resultado do teste seja �verde�, isto �,
	 * aprovado no teste
	 */
	@Test(expected = NullPointerException.class)
	public void incTest() {
		when(a.inc()).thenReturn(1, 2, 3, 4).thenThrow(new NullPointerException("Al�m do limite"));
		while (true) {
			System.out.println(a.inc());
		}
	}

}
