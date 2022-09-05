package servico;

import dominio.Familia;

public class CriterioRendaFamiliar implements Criterio {

	@Override
	public int pontuacao(Familia familia) {
		
		int pontuacao = 0;
		
		if(familia.getRenda() <= 900) {
			
			pontuacao = 5;
			
		} else if(familia.getRenda() >= 901 && familia.getRenda() <= 1500) {
			
			pontuacao = 3;
			
		}
		
		return pontuacao;
	}
}
