/**
 * 
 */
package br.ufpi.easii.redeNeural;

import br.ufpi.easii.funcaoDeAtivacao.FuncaoDegrau;
import br.ufpi.easii.neuronios.Neuronio;

/**
 * @author Ronyerison
 *
 */
public class Perceptron extends Neuronio{
	@SuppressWarnings("unused")
	private int quantEpocas;
	
	public Perceptron() {
		super(new FuncaoDegrau());
	}
	
	public void treinamento(Double[][] entradas, Double[] saidaDesejada, 
			Double taxaDeAprendizagem ){
		gerarPesos(entradas[0].length);
		Boolean erro;
		do{
			erro = false;
			for(int i=0;i<entradas.length;i++){
				somatorio(entradas[i]);
				ativarNeuronio();
				if(this.saida != saidaDesejada[i]){
					recalculaPeso(taxaDeAprendizagem, saidaDesejada[i], entradas[i]);
					erro = true;
				}
			}
			
			this.quantEpocas++;
		}while(!erro);
	}

	public void executar(Double[] entradas) {
		somatorio(entradas);
		ativarNeuronio();
		if(this.saida == 0.0){
			System.out.println("Jogador de Futebol");
		}else{
			System.out.println("Jogador de Tênis");
		}
	}
	
	public void recalculaPeso(Double taxaDeAprendizagem, Double saidaDesejada, Double[] entradas) {
		for (int i = 0; i < entradas.length; i++) {
			this.pesos[i] += taxaDeAprendizagem*(saidaDesejada-this.saida)*entradas[i];
		}
	}
	
	
}
