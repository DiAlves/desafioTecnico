package servico;

import java.util.Collections;
import java.util.List;

import dominio.Familia;
import recurso.FabricaCriterio;


/*
 * Classe que tem o m�todo capaz de ordenar as fam�lias pela pontua��o
 */
public class ServicoListar {
	
	public static List<Familia> ordenacaoPorPontuacao(List<Familia> familias, FabricaCriterio fabrica) {
		
		// Passando pelos crit�rios especificados na classe FabricaCriterio
		for(String criterio : fabrica.getCriterios().keySet()) {
			
			Criterio criterioImplementado = fabrica.pegarCriterio(criterio);
			
			// Atualiza a pontua��o de cada Fam�lia de acordo com o crit�rio em quest�o
			familias.forEach(familia -> criterioImplementado.pontuacao(familia));
					
		}
		
		// Realiza a ordena��o da lista de Fam�lias 
		Collections.sort(familias, Collections.reverseOrder());
		
		return familias;
		
	}
	
}
