package dominio;

import java.util.List;

public class Familia {
	
	private Pessoa responsavel;
	
	private Pessoa conjuge;
	
	private float renda;
	
	private List<Pessoa> dependentes;

	public Familia(Pessoa responsavel, Pessoa conjuge, float renda, List<Pessoa> dependentes) {
	
		this.responsavel = responsavel;
		this.conjuge = conjuge;
		this.renda = renda;
		this.dependentes = dependentes;
	}

	public Pessoa getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}

	public Pessoa getConjuge() {
		return conjuge;
	}

	public void setConjuge(Pessoa conjuge) {
		this.conjuge = conjuge;
	}

	public float getRenda() {
		return renda;
	}

	public void setRenda(float renda) {
		this.renda = renda;
	}

	public List<Pessoa> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Pessoa> dependentes) {
		this.dependentes = dependentes;
	}
	
}
