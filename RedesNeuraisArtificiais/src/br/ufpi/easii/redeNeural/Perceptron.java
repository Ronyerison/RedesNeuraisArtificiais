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
			Double taxaDeAprendizagem, Integer maxEpocas ){
		if(!pesosSetados){
			gerarPesos(entradas[0].length);
		}
		boolean erro;
		do{
			strResult.append("Epoca = ;"+ (quantEpocas) + "\nPesos = ;");
			for (Double peso : pesos) {
				strResult.append(peso.toString().replace(".", ",") + ";");
			}
			strResult.append("\n");
			erro = false;
			for(int i=0;i<saidaDesejada.length;i++){
				somatorio(entradas[i]);
				ativarNeuronio();
				
				if(this.saida.intValue() != saidaDesejada[i].intValue()){
					recalculaPeso(taxaDeAprendizagem, saidaDesejada[i], entradas[i]);
					erro = true;
				}
				strResult.append("Amostra = ;"+ (i+1)+ ";Erro = ;" + erro + "\n");
			}
			
			System.out.println(quantEpocas);
			this.quantEpocas++;
		}while(erro && this.quantEpocas < maxEpocas);

	}

	public void executar(Double[] entradas) {
		somatorio(entradas);
		ativarNeuronio();
		System.out.println("saida = " + this.saida);
//		if(this.saida == -1.0){
//		}else{
//			System.out.println("saida = " + this.saida);
//		}
	}
	
	public void recalculaPeso(Double taxaDeAprendizagem, Double saidaDesejada, Double[] entradas) {
		this.pesoBias += taxaDeAprendizagem*(saidaDesejada-this.saida)*-1;
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
	
	public void zerarPesos(int tam){
		this.pesos = new Double[tam];
		for (int i = 0; i < this.pesos.length; i++) {
			this.pesos[i] = 0.0;
		}
		this.pesoBias = 0.0;
		this.pesosSetados = true;
	}
	
}
