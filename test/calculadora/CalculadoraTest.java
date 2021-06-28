package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testar calculo do somatorio de 3")
	@Test
	public void testeSomatoria() {
		int somatoria = calc.somatoria(3);
		assertEquals(6, somatoria);
	}

	@DisplayName("Testa que um numero e positivo")
	@Test
	public void testeNumeroPositivo() {
		assertTrue(calc.ehPositivo(5));
	}

	@DisplayName("Testa que um numero e negativo")
	@Test
	public void testeNumeroNegativo() {
		Assertions.assertFalse(calc.ehPositivo(-5));
	}

	@DisplayName("Testar comparacao numero A maior que B")
	@Test
	public void testeComparaAMaiorQueB() {
		int a = 10;
		int b = 5;
		assertEquals(1, calc.compara(a, b));
	}

	@DisplayName("Testar comparacao numero A menor que B")
	@Test
	public void testeComparaAMenorQueB() {
		int a = 5;
		int b = 10;
		assertEquals(-1, calc.compara(a, b));
	}

	@DisplayName("Testar comparacao entre numeros iguais")
	@Test
	public void testeComparaABIguais() {
		int a = 5;
		int b = 5;
		assertEquals(0, calc.compara(a, b));
	}

	@DisplayName("Testar subtracao com resultado positivo")
	@Test
	public void testeSubtracaoPositiva() {
		assertEquals(1, calc.subtracao(3, 2));
	}

	@DisplayName("Testar subtracao com resultado negativo")
	@Test
	public void testeSubtracaoNegativa() {
		assertEquals(-1, calc.subtracao(2, 3));
	}

	@DisplayName("Testar multiplicacao entre dois numeros")
	@Test
	public void testeMultiplicacao() {
		assertEquals(6, calc.multiplicacao(2, 3));
	}

	@DisplayName("Testar multiplicacao por zero")
	@Test
	public void testeMultiplicacaoZero() {
		assertEquals(0, calc.multiplicacao(0, 5));
	}

}
