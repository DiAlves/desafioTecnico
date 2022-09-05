package servico;

import dominio.Familia;
import dominio.Pessoa;

public class CriterioNumeroDependentes implements Criterio {

	@Override
	public int pontuacao(Familia familia) {
		
		int numeroDependentes = 0;
		int pontuacao = 0;
		
		for(Pessoa dependente : familia.getDependentes()) {
			
			if(!dependente.maiorDeIdade()) {
				numeroDependentes++;
			}
			
		}
		
		if(numeroDependentes >= 3) {
			
			pontuacao = 3;
			
		} else if (numeroDependentes == 1 || numeroDependentes == 2){
			
			pontuacao = 2;
			
		}
		
		return pontuacao;
	}

}
