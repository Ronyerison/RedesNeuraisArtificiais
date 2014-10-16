/**
 * 
 */
package br.ufpi.easii.redeNeural;

import java.io.BufferedWriter;
import java.io.FileWriter;

import br.ufpi.easii.camadas.Camada;
import br.ufpi.easii.funcaoDeAtivacao.FuncaoLinear;
import br.ufpi.easii.funcaoDeAtivacao.FuncaoTangenteHiperbolica;

/**
 * @author Ronyerison
 *
 */
public class RandomNeuralNetwork extends MultiLayerPerceptron{
	public Double[][] matriz = new Double[100][2];

	public RandomNeuralNetwork(Integer[] camadas) {
		super(camadas);
		this.camadaDeSaida.setFuncaoDeAtivacao(new FuncaoLinear());
		for (Camada camada : this.camadasIntermediarias) {
			camada.setFuncaoDeAtivacao(new FuncaoTangenteHiperbolica());
		}
	}

	public void randomTraining(Double[][] amostras, Double[][] esperado, double maxEpocas, double precisao){
		double erroAnterior, erroTemp;

		if (!pesosSetados) {
			inicializarPesos(amostras[0].length);
		}

		this.erroMedio = 0.0;
		this.quantEpocas = 0;

		do {
			erroTemp = 0.0;
			erroAnterior = this.erroMedio;

			/* Irá percorrer todas as amostras e calcular o erro médio */
			for (int i = 0; i < amostras.length; i++) {
				camadasIntermediarias.get(0).combinarEntradas(amostras[i]);
				camadasIntermediarias.get(0).gerarSaidas();
				for (int j = 1; j < camadasIntermediarias.size(); j++) {
					camadasIntermediarias.get(j).combinarEntradas(camadasIntermediarias.get(j - 1).getVetorSaida());
					camadasIntermediarias.get(j).gerarSaidas();
				}
				camadaDeSaida.combinarEntradas(camadasIntermediarias.get(camadasIntermediarias.size() - 1).getVetorSaida());
				camadaDeSaida.gerarSaidas();
				erroTemp += Math.pow(calcularErro(esperado[i]),2);
				Double rand = (Math.random()/erroTemp);
				camadaDeSaida.ajustarPesosRandom(rand);
				for (Camada camada : camadasIntermediarias) {
					camada.ajustarPesosRandom(rand);
				}
			}
			erroMedio = erroTemp / amostras.length;
			matriz[quantEpocas][0] = erroMedio; matriz[quantEpocas][1] = (double) (quantEpocas+1);
			quantEpocas++;
			System.out.println("ErroQM: "+ erroMedio +"\tEpoca:" + quantEpocas);
		} while (Math.abs(erroMedio-erroAnterior) > precisao && quantEpocas < maxEpocas);

		salvarNoArquivo("erroQM.csv");
	}
	
	public void salvarNoArquivo(String nome){
		try {
			FileWriter fileWriter = new FileWriter(nome);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < this.matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					bufferedWriter.write(matriz[i][j].toString().replace('.', ',') + ";");
				}
				bufferedWriter.write("\n");
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
