package recurso;

import java.util.HashMap;
import java.util.Map;

import servico.Criterio;
import servico.CriterioNumeroDependentes;
import servico.CriterioRendaFamiliar;

/*
 * Classe respons�vel por criar inst�ncias para os diferentes crit�rios de pontua��o
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

	// Fun��o que retorna a inst�ncia de Criterio a partir do crit�rio especificado 
    public Criterio pegarCriterio(String criterio) {
    	
        return criterios.get(criterio);
        
    }
}
