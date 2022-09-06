package servico;

import java.util.Collections;
import java.util.List;

import dominio.Familia;
import recurso.FabricaCriterio;


/*
 * Classe que tem o método capaz de ordenar as famílias pela pontuação
 */
public class ServicoListar {
	
	public static List<Familia> ordenacaoPorPontuacao(List<Familia> familias, FabricaCriterio fabrica) {
		
		// Passando pelos critérios especificados na classe FabricaCriterio
		for(String criterio : fabrica.getCriterios().keySet()) {
			
			Criterio criterioImplementado = fabrica.pegarCriterio(criterio);
			
			// Atualiza a pontuação de cada Família de acordo com o critério em questão
			familias.forEach(familia -> criterioImplementado.pontuacao(familia));
					
		}
		
		// Realiza a ordenação da lista de Famílias 
		Collections.sort(familias, Collections.reverseOrder());
		
		return familias;
		
	}
	
}
