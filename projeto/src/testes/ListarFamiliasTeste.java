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
import servico.ListarFamilias;

/*
 * Classe de teste criada para garantir o funcionamento da listagem das familias
 */
public class ListarFamiliasTeste {
	
	// Familias
	private Familia familia1;
	private Familia familia2;
	private Familia familia3;
	
	// Responsaveis e Conjuges
	private Pessoa pessoa;
	private Pessoa conjuge;
	
	// Dependentes
	private Pessoa dependente1;
	private Pessoa dependente2;
	private Pessoa dependente3;
	
	List<Pessoa> dependentes;
	List<Familia> listaFamilia;
	
	// Montando o cenário
	@Before
	public void configuracao() {
		
		// Familia 1
		pessoa = new Pessoa("Maria", 39);
		conjuge = new Pessoa("João", 42);
		dependente1 = new Pessoa("Felipe", 10);
		dependente2 = new Pessoa("Maisa", 6);
		dependente3 = new Pessoa("Marcela", 19);

		dependentes = new ArrayList<>();
		dependentes.add(dependente1);
		dependentes.add(dependente2);
		dependentes.add(dependente3);

		familia1 = new Familia(pessoa, conjuge, 2500, dependentes);
		
		// Familia 2
		pessoa = new Pessoa("Alexandre", 35);
		conjuge = new Pessoa("Juliana", 35);
		dependente2 = new Pessoa("Junior", 6);

		dependentes = new ArrayList<>();
		dependentes.add(dependente2);

		familia2 = new Familia(pessoa, conjuge, 1300, dependentes);
		
		// Familia 3
		pessoa = new Pessoa("Wesley", 29);
		conjuge = new Pessoa("Lais", 30);
		dependente1 = new Pessoa("Pedro", 10);
		dependente2 = new Pessoa("Taina", 6);
		dependente3 = new Pessoa("Matheus", 2);

		dependentes = new ArrayList<>();
		dependentes.add(dependente1);
		dependentes.add(dependente2);
		dependentes.add(dependente3);

		familia3 = new Familia(pessoa, conjuge, 900, dependentes);
		
		listaFamilia = new ArrayList<>();
		listaFamilia.add(familia1);
		listaFamilia.add(familia2);
		listaFamilia.add(familia3);
		
	}
		
	/**
	 * Teste básico para ordenar as familias pela pontuacao
	 */
	@Test
	public void testeOrdenacaoPorPontuacao() {
		
		List<Familia> familiasOrdenadasResultadoEsperado = new ArrayList<>();
		familiasOrdenadasResultadoEsperado.add(familia3);
		familiasOrdenadasResultadoEsperado.add(familia2);
		familiasOrdenadasResultadoEsperado.add(familia1);
		
		// Execução
		List<Familia> familiasOrdenadas = ListarFamilias.ordenacaoPorPontuacao(listaFamilia, new FabricaCriterio());
		
		// Verificação
		assertThat(familiasOrdenadasResultadoEsperado.equals(familiasOrdenadas), is(true));
		
	}
}
