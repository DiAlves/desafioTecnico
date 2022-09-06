package servico;

import dominio.Familia;
import dominio.Pessoa;

/*
 * Classe que implementa o crit�rio de n�mero de dependentes de uma Fam�lia
 */
public class CriterioNumeroDependentes implements Criterio {

	@Override
	public void pontuacao(Familia familia) {
		
		int numeroDependentes = 0;
		Integer pontuacao = familia.getPontuacao();
		
		for(Pessoa dependente : familia.getDependentes()) {
			
			if(!dependente.maiorDeIdade()) {
				numeroDependentes++;
			}
			
		}
		
		if(numeroDependentes >= 3) {
			
			pontuacao = pontuacao + 3;
			
		} else if (numeroDependentes == 1 || numeroDependentes == 2){
			
			pontuacao = pontuacao + 2;
			
		}
		
		familia.setPontuacao(pontuacao);

	}

}
