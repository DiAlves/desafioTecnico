package servico;

import dominio.Familia;

/*
 * Classe que implementa o critério de renda total da família
 */
public class CriterioRendaFamiliar implements Criterio {

	@Override
	public void pontuacao(Familia familia) {
		
		Integer pontuacao = familia.getPontuacao();
		
		if(familia.getRenda() <= 900) {
			
			pontuacao = pontuacao + 5;
			
		} else if(familia.getRenda() >= 901 && familia.getRenda() <= 1500) {
			
			pontuacao = pontuacao + 3;
			
		}
		
		familia.setPontuacao(pontuacao);
		
	}
}
