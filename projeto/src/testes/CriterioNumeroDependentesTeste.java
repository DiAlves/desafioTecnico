package testes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dominio.Familia;
import dominio.Pessoa;
import recurso.FabricaCriterio;
import servico.Criterio;

/*
 * Classe de teste criada para garantir o funcionamento das operações
 * sobre a pontução dentro do Critério Número de Dependentes válidos
 */
public class CriterioNumeroDependentesTeste {
	
	private Familia familia;
	private Pessoa pessoa;
	private Pessoa conjuge;
	
	// Dependentes
	private Pessoa dependente1;
	private Pessoa dependente2;
	private Pessoa dependente3;
	private Pessoa dependente4;
	
	Criterio criterioRendaFamiliar;
	
	// Montando o cenário
	@Before
	public void configuracao() {
		
		pessoa = new Pessoa("Jonas", 48);
		conjuge = new Pessoa("Thays", 49);
		
		dependente1 = new Pessoa("Renan", 17);
		dependente2 = new Pessoa("Kauan", 13);
		dependente3 = new Pessoa("Clara", 9);
		dependente4 = new Pessoa("Cris", 19);
		
		familia = new Familia(pessoa, conjuge, 5000, new ArrayList<>());
		
		FabricaCriterio fabricaCriterio = new FabricaCriterio();
		criterioRendaFamiliar = fabricaCriterio.pegarCriterio("NumeroDependentes");
		
	}
	
	/**
	 * Teste básico para a família com 3 ou mais dependentes
	 */
	@Test
	public void testePontuacaoTresOuMaisDependentes() {
		
		List<Pessoa> dependentes = new ArrayList<>();
		dependentes.add(dependente1);
		dependentes.add(dependente2);
		dependentes.add(dependente3);
		
		familia.setDependentes(dependentes);
		
		// Execução
		criterioRendaFamiliar.pontuacao(familia);
		
		// Verificação
		assertThat(familia.getPontuacao(), is(3));
		
	}
	
	/**
	 * Teste básico para a família com 1 ou 2 dependentes
	 */
	@Test
	public void testePontuacaoUmOuDoisDependentes() {
		
		List<Pessoa> dependentes = new ArrayList<>();
		dependentes.add(dependente2);
		dependentes.add(dependente3);
		
		familia.setDependentes(dependentes);
		
		// Execução
		criterioRendaFamiliar.pontuacao(familia);
		
		// Verificação
		assertThat(familia.getPontuacao(), is(2));
		
	}
	
	/**
	 * Teste básico para a família com nenhum dependente válido
	 */
	@Test
	public void testePontuacaoSemDependente() {
		
		List<Pessoa> dependentes = new ArrayList<>();
		dependentes.add(dependente4);
		
		familia.setDependentes(dependentes);
		
		// Execução
		criterioRendaFamiliar.pontuacao(familia);
		
		// Verificação
		assertThat(familia.getPontuacao(), is(0));
		
	}
}
