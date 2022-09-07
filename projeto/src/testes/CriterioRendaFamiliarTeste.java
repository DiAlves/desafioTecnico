package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import dominio.Familia;
import dominio.Pessoa;
import recurso.FabricaCriterio;
import servico.Criterio;

/*
 * Classe de teste criada para garantir o funcionamento das opera��es
 * sobre a pontu��o dentro do Crit�rio Renda Familiar
 */
public class CriterioRendaFamiliarTeste {
	
	private Familia familia;
	private Pessoa pessoa;
	private Pessoa conjuge;
	
	Criterio criterioRendaFamiliar;
	
	// Montando o cen�rio
	@Before
	public void configuracao() {
		
		pessoa = new Pessoa("Ana", 34);
		conjuge = new Pessoa("Alex", 36);
		
		familia = new Familia(pessoa, conjuge, 5000, new ArrayList<>());
		
		FabricaCriterio fabricaCriterio = new FabricaCriterio();
		criterioRendaFamiliar = fabricaCriterio.pegarCriterio("RendaFamiliar");
		
	}
	
	/**
	 * Teste b�sico para a fam�lia com renda familiar at� 900 reais
	 */
	@Test
	public void testePontuacaoRendaAte900() {
		
		float rendaFamiliar = 800;
		familia.setRenda(rendaFamiliar);
		
		// Execu��o
		criterioRendaFamiliar.pontuacao(familia);
		
		// Verifica��o
		assertThat(familia.getPontuacao(), is(5));
		
	}
	
	/**
	 * Teste b�sico para a fam�lia com renda familiar entre 901 e 1500 reais 
	 */
	@Test
	public void testePontuacaoRendaEntre901E1500() {
		
		float rendaFamiliar = 1200;
		familia.setRenda(rendaFamiliar);
		
		// Execu��o
		criterioRendaFamiliar.pontuacao(familia);
		
		// Verifica��o
		assertThat(familia.getPontuacao(), is(3));
		
	}
	
	/**
	 * Teste b�sico para a fam�lia com renda familiar fora do intervalo
	 */
	@Test
	public void testePontuacaoRendaForaDoIntervalo() {
		
		float rendaFamiliar = 3000;
		familia.setRenda(rendaFamiliar);
		
		// Execu��o
		criterioRendaFamiliar.pontuacao(familia);
		
		// Verifica��o
		assertThat(familia.getPontuacao(), is(0));
		
	}
}
