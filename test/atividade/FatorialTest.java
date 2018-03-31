package atividade;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.runners.Parameterized;

/**
 * @author Karen 30 de mar de 2018
 */
@RunWith(Parameterized.class)
public class FatorialTest {

	@Mock
	private A a = null;
	
	private long entrada;
	private long saida;

	@Before
	public void setUp() {
		/* o método mock cria um objeto do tipo Operacao */
		a = mock(A.class);
	}
	
	public FatorialTest(long entrada, long saida) {
		this.entrada = entrada;
		this.saida = saida;
	}
	
	@Parameterized.Parameters
    public static Collection parametros() {
        return Arrays.asList(new Object[][]{
            {0, 0},
            {1, 1},
            {2, 2},
            {5, 120}});
    }

	/**
	 * Exercício 6 – Criar uma classe parametrizada de nome FatorialTest para
	 * testar o método fatorial nas seguintes situações:
	 * 
	 */
	@Test
	public void test1() throws Exception {
		when(a.fatorial(entrada)).thenReturn(saida);

	}

}
