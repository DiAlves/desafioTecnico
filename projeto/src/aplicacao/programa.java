package aplicacao;

import java.util.ArrayList;
import java.util.List;

import dominio.Familia;
import dominio.Pessoa;
import recurso.FabricaCriterio;
import servico.ServicoListar;

/*
 * Classe para demonstração
 */
public class Programa {
	
	public static void main(String[] args) {
		
		
		// Familia 1
		Pessoa pessoa1 = new Pessoa("Maria", 39);
		Pessoa conjuge1 = new Pessoa("João", 42);
		Pessoa dependente11 = new Pessoa("Felipe", 10);
		Pessoa dependente12 = new Pessoa("Maisa", 6);
		Pessoa dependente13 = new Pessoa("Marcela", 1);

		List<Pessoa> dependentes1 = new ArrayList<>();
		dependentes1.add(dependente11);
		dependentes1.add(dependente12);
		dependentes1.add(dependente13);

		Familia familia1 = new Familia(pessoa1, conjuge1, 2500, dependentes1);
		
		// Familia 2
		Pessoa pessoa2 = new Pessoa("Lucas", 35);
		Pessoa conjuge2 = new Pessoa("Fernanda", 36);
		Pessoa d21 = new Pessoa("Mario", 7);
		Pessoa d22 = new Pessoa("Paulo", 2);

		List<Pessoa> dependentes2 = new ArrayList<>();
		dependentes2.add(d21);
		dependentes2.add(d22);

		Familia familia2 = new Familia(pessoa2, conjuge2, 1500, dependentes2);
		
		// Familia 3
		Pessoa pessoa3 = new Pessoa("Joana", 24);
		Pessoa conjuge3 = new Pessoa("Rafael", 24);

		Familia familia3 = new Familia(pessoa3, conjuge3, 2000, new ArrayList<>());

		List<Familia> listaFamilia = new ArrayList<>();
		listaFamilia.add(familia1);
		listaFamilia.add(familia2);
		listaFamilia.add(familia3);

		
		List<Familia> familiasListadas = ServicoListar.ordenacaoPorPontuacao(listaFamilia, new FabricaCriterio());
		
		System.out.println("------ Listagem das Famílias ------");
		
		for(Familia familia : familiasListadas) {
			
			System.out.println(familia);
		}
	}
}
