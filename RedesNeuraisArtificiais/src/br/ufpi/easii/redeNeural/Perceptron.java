/**
 * 
 */
package br.ufpi.easii.redeNeural;

import java.util.Arrays;

import br.ufpi.easii.funcaoDeAtivacao.FuncaoDegrau;
import br.ufpi.easii.neuronios.Neuronio;

/**
 * @author Ronyerison
 *
 */
public class Perceptron extends Neuronio{
	
	private int quantEpocas;
	private StringBuffer strResult;
	public boolean pesosSetados;
	
	public Perceptron() {
		super(new FuncaoDegrau());
		this.quantEpocas = 0;
		strResult = new StringBuffer("");
		pesosSetados = false;
	}
	
	public void treinamento(Double[][] entradas, Double[] saidaDesejada, 
			Double taxaDeAprendizagem ){
		strResult.append("--------------------Treinamento--------------------\n");
		if(!pesosSetados){
			gerarPesos(entradas[0].length);
		}
		
		boolean erro;
		do{
			erro = false;
			strResult.append("EPOCA " + quantEpocas);
			strResult.append("\nPesos Atuais:" + Arrays.toString(getPesos()) + "\n");
			for(int i=0;i<saidaDesejada.length;i++){
				somatorio(entradas[i]);
				ativarNeuronio();
				strResult.append("Saida Desejada: " + saidaDesejada[i]);
				strResult.append("Saida Atual: " + saida+"\n");
//				System.out.println("Saida = "+this.saida.intValue()+"\nSaida Desejada = "+saidaDesejada[i].intValue());
				
				if(this.saida.intValue() != saidaDesejada[i].intValue()){
					recalculaPeso(taxaDeAprendizagem, saidaDesejada[i], entradas[i]);
					erro = true;
					strResult.append("\nAtualizando Pesos: " + Arrays.toString(getPesos()) +"\n");
				}
			}
			
			this.quantEpocas++;
		}while(erro);
		//System.out.println(quantEpocas);
	}

	public void executar(Double[] entradas) {
		somatorio(entradas);
		ativarNeuronio();
		if(this.saida == 0.0){
			strResult.append("\nJogador de Futebol == 0.0\n");
		}else{
			strResult.append("\nJogador de Tênis == 1.0\n");
		}
	}
	
	public void recalculaPeso(Double taxaDeAprendizagem, Double saidaDesejada, Double[] entradas) {
		for (int i = 0; i < pesos.length; i++) {
			this.pesos[i] += taxaDeAprendizagem*(saidaDesejada-this.saida)*entradas[i];
		}
	}

	/**
	 * @return the quantEpocas
	 */
	public int getQuantEpocas() {
		return quantEpocas;
	}

	/**
	 * @param quantEpocas the quantEpocas to set
	 */
	public void setQuantEpocas(int quantEpocas) {
		this.quantEpocas = quantEpocas;
	}

	/**
	 * @return the strResult
	 */
	public StringBuffer getStrResult() {
		return strResult;
	}

	/**
	 * @param strResult the strResult to set
	 */
	public void setStrResult(StringBuffer strResult) {
		this.strResult = strResult;
	}
	
	
}
