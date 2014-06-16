/**
 * 
 */
package br.ufpi.easii.neuronios;

import java.util.Random;

import br.ufpi.easii.funcaoDeAtivacao.AbstractFunction;
import br.ufpi.easii.funcaoDeAtivacao.FuncaoDegrau;

/**
 * @author Ronyerison
 *
 */
public class Neuronio {
	
	protected Double[] pesos;
	protected AbstractFunction funcaoDeAtivacao;
	protected Double potencialDeAtivacao;
	protected Double pesoBias;
	protected Double saida;

	/**
	 * @param pesos
	 * @param funcaoDeAtivacao
	 * @param potencialDeAtivacao
	 * @param pesoBias
	 */
	public Neuronio(Double[] pesos, AbstractFunction funcaoDeAtivacao,
			Double potencialDeAtivacao, Double pesoBias) {
		this.pesos = pesos;
		this.funcaoDeAtivacao = funcaoDeAtivacao;
		this.potencialDeAtivacao = potencialDeAtivacao;
		this.pesoBias = pesoBias;
	}
	
	public Neuronio() {
		this.potencialDeAtivacao = 0.0;
		this.funcaoDeAtivacao = new FuncaoDegrau();
		this.pesoBias = new Random().nextDouble()*1;
	}
	
	@SuppressWarnings("unused")
	public void gerarPesos(int tam){
		this.pesos = new Double[tam];
		for (Double peso : this.pesos) {
			peso = new Random().nextDouble()*1;
		}
	}
	
	public void somatorio(Double[] conexoes){
		Double soma = 0.0;
		soma = pesoBias * -1;
		for (int i = 0; i < conexoes.length; i++) {
			soma += conexoes[i] * pesos[i];
		}
		this.potencialDeAtivacao = soma;
	}
	
	public void ativarNeuronio(){
		this.saida = funcaoDeAtivacao.ativar(potencialDeAtivacao);
	}

	
	/**
	 * @return the pesos
	 */
	public Double[] getPesos() {
		return pesos;
	}

	/**
	 * @param pesos the pesos to set
	 */
	public void setPesos(Double[] pesos) {
		this.pesos = pesos;
	}

	/**
	 * @return the funcaoDeAtivacao
	 */
	public AbstractFunction getFuncaoDeAtivacao() {
		return funcaoDeAtivacao;
	}

	/**
	 * @param funcaoDeAtivacao the funcaoDeAtivacao to set
	 */
	public void setFuncaoDeAtivacao(AbstractFunction funcaoDeAtivacao) {
		this.funcaoDeAtivacao = funcaoDeAtivacao;
	}

	/**
	 * @return the potencialDeAtivacao
	 */
	public Double getPotencialDeAtivacao() {
		return potencialDeAtivacao;
	}

	/**
	 * @param potencialDeAtivacao the potencialDeAtivacao to set
	 */
	public void setPotencialDeAtivacao(Double potencialDeAtivacao) {
		this.potencialDeAtivacao = potencialDeAtivacao;
	}

	/**
	 * @return the pesoBias
	 */
	public Double getPesoBias() {
		return pesoBias;
	}

	/**
	 * @param pesoBias the pesoBias to set
	 */
	public void setPesoBias(Double pesoBias) {
		this.pesoBias = pesoBias;
	}

	/**
	 * @return the saida
	 */
	public Double getSaida() {
		return saida;
	}

	/**
	 * @param saida the saida to set
	 */
	public void setSaida(Double saida) {
		this.saida = saida;
	}
	
	
}
