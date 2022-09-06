package recurso;

import java.util.HashMap;
import java.util.Map;

import servico.Criterio;
import servico.CriterioNumeroDependentes;
import servico.CriterioRendaFamiliar;

/*
 * Classe responsável por criar instâncias para os diferentes critérios de pontuação
 */
public class FabricaCriterio {
	
    private Map<String, Criterio> criterios = new HashMap<>();
    
    public FabricaCriterio() {
    	
    	criterios.put("RendaFamiliar", new CriterioRendaFamiliar());
    	criterios.put("NumeroDependentes", new CriterioNumeroDependentes());
    }
    
    public Map<String, Criterio> getCriterios() {
		return criterios;
	}

	// Função que retorna a instância de Criterio a partir do critério especificado 
    public Criterio pegarCriterio(String criterio) {
    	
        return criterios.get(criterio);
        
    }
}
