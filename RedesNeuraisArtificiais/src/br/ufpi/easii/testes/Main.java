/**
 * 
 */
package br.ufpi.easii.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.ufpi.easii.neuronios.Neuronio;
import br.ufpi.easii.redeNeural.MultiLayerPerceptron;
import br.ufpi.easii.redeNeural.Perceptron;

/**
 * @author Ronyerison
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Double[] pesosL = {0.7, 0.1};
		// Neuronio neuronioL = new Neuronio(pesosL, new FuncaoLogistica(),
		// 0.25);
		// Double[] entradasL = {0.0, 0.0};
		// gerarArquivo("questaoL.csv",neuronioL, entradasL);

		// Integer[] camadas = {10,5,1};
		// MultiLayerPerceptron rna = new MultiLayerPerceptron(camadas);
		// Double[] entradas = {0.0, 0.0};
		// gerarArquivoRedeNeural("Rna6e.csv", rna, entradas);

		// Double[][] amostras = new Double[10][2];
		// amostras[0][0] = 0.9;amostras[0][1] = 0.1;
		// amostras[1][0] = 0.6;amostras[1][1] = 0.5;
		// amostras[2][0] = 0.2;amostras[2][1] = 0.8;
		// amostras[3][0] = 0.7;amostras[3][1] = 0.2;
		// amostras[4][0] = 0.5;amostras[4][1] = 0.4;
		// amostras[5][0] = 0.4;amostras[5][1] = 0.6;
		// amostras[6][0] = 0.25;amostras[6][1] = 0.8;
		// amostras[7][0] = 0.1;amostras[7][1] = 0.9;
		// amostras[8][0] = 0.3;amostras[8][1] = 0.7;
		// amostras[9][0] = 0.0;amostras[9][1] = 1.0;

		Double[] desejado = new Double[10];
		desejado[0] = 1.0;
		desejado[1] = 1.0;
		desejado[2] = -1.0;
		desejado[3] = 1.0;
		desejado[4] = -1.0;
		desejado[5] = 1.0;
		desejado[6] = -1.0;
		desejado[7] = -1.0;
		desejado[8] = -1.0;
		desejado[9] = -1.0;

		// Perceptron perceptron = new Perceptron();
		// perceptron.treinamento(amostras, desejado, 0.3, 100);
		// Double[] teste = {0.6, 0.7};
		// perceptron.executar(teste);
		// Double[][] amostras2 = new Double[10][1];
		// amostras2[0][0] = 0.9;
		// amostras2[1][0] = 0.6;
		// amostras2[2][0] = 0.2;
		// amostras2[3][0] = 0.7;
		// amostras2[4][0] = 0.5;
		// amostras2[5][0] = 0.4;
		// amostras2[6][0] = 0.25;
		// amostras2[7][0] = 0.1;
		// amostras2[8][0] = 0.3;
		// amostras2[9][0] = 0.0;
		//
		// Double[][] esperado = new Double[10][1];
		// esperado[0][0] = 1.0;
		// esperado[1][0] = 1.0;
		// esperado[2][0] = -1.0;
		// esperado[3][0] = 1.0;
		// esperado[4][0] = -1.0;
		// esperado[5][0] = 1.0;
		// esperado[6][0] = -1.0;
		// esperado[7][0] = -1.0;
		// esperado[8][0] = -1.0;
		// esperado[9][0] = -1.0;
		// Integer[] camadas = {3,1};
		// RandomNeuralNetwork net = new RandomNeuralNetwork(camadas);
		// net.randomTraining(amostras2, esperado, 100, 0.01);

		Double[][] amostras = new Double[4][2];
		amostras[0][0] = 0.49;
		amostras[0][1] = 0.49;
		amostras[1][0] = 0.49;
		amostras[1][1] = 0.51;
		amostras[2][0] = 0.51;
		amostras[2][1] = 0.49;
		amostras[3][0] = 0.51;
		amostras[3][1] = 0.51;

		Double[] desejado2 = new Double[4];
		desejado2[0] = 0.0;
		desejado2[1] = 1.0;
		desejado2[2] = 1.0;
		desejado2[3] = 1.0;
		
		
		Perceptron perceptron = new Perceptron();
		perceptron.zerarPesos(amostras[0].length);
//		Double[][] arquivo = lerAqruivo("Treinamento_Perceptron.csv", new Double[30][4]);
//		Double[][] amostras = new Double[30][3];
//		for (int i = 0; i < amostras.length; i++) {
//			for (int j = 0; j < amostras[i].length; j++) {
//				amostras[i][j] = arquivo[i][j];
//			}
//		}
//		for (int i = 0; i < 30; i++) {
//			desejado2[i] = arquivo[i][3];
//		}
		
//		Double[][] teste = lerAqruivo("Teste_Perceptron.csv", new Double[10][3]);
		arquivoPerceptron("Perceptron2.csv", perceptron, amostras, desejado2, null, 1.0, 2000);
//		perceptron.treinamento(amostras, desejado2, 0.01, 100);
//		Double[] teste = { 0.9, 0.8 };
//		perceptron.executar(teste);
	}

	public static void gerarArquivo(String nome, Neuronio neuronio,
			Double[] entradas) {
		try {
			FileWriter fileWriter = new FileWriter(nome);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			double discretizacao = 0.05;

			for (int i = 0; i < 20; i++) {
				neuronio.somatorio(entradas);
				neuronio.ativarNeuronio();
				for (int j = 0; j < entradas.length; j++) {
					bufferedWriter.write(entradas[j].toString().replace('.',
							',')
							+ ";");
					entradas[j] = entradas[j] + discretizacao;
				}
				bufferedWriter.write(neuronio.getSaida().toString()
						.replace('.', ',')
						+ "\n");

			}

			bufferedWriter.close();
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void arquivoPerceptron(String nome, Perceptron perceptron,
			Double[][] amostras, Double[] esperado, Double[][] testes,
			Double taxa, Integer maxEpocas) {
		try {
			FileWriter fileWriter = new FileWriter(nome);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

//			for (int i = 0; i < 5; i++) {
				bufferedWriter.write("\n\nTreinamento \n");
//				perceptron.gerarPesos(amostras[0].length);
				bufferedWriter.write("Pesos iniciais\n");
				bufferedWriter.write(perceptron.getPesoBias().toString().replace(".", ",") + ";");
				for (Double peso : perceptron.getPesos()) {
					bufferedWriter.write(peso.toString().replace(".", ",")
							+ ";");
				}
				bufferedWriter.write("\n");
				perceptron.treinamento(amostras, esperado, taxa, maxEpocas);

				bufferedWriter.write("Pesos Finais\n");
				bufferedWriter.write(perceptron.getPesoBias().toString().replace(".", ",") + ";");
				for (Double peso : perceptron.getPesos()) {
					bufferedWriter.write(peso.toString().replace(".", ",")
							+ ";");
				}
				bufferedWriter.write("\n"+ perceptron.getStrResult());

//				bufferedWriter.write("Epocas = ;" + perceptron.getQuantEpocas()
//						+ "\n");
				
				
				if(testes != null){
					bufferedWriter.write("Saida\n");
					for (int j = 0; j < testes.length; j++) {
						perceptron.executar(testes[j]);
						bufferedWriter.write(perceptron.getSaida().toString().replace(".", ",")+";");
					}
				}

//			}

			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void gerarArquivoRedeNeural(String nome,
			MultiLayerPerceptron rna, Double[] entradas) {
		try {
			FileWriter fileWriter = new FileWriter(nome);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			double discretizacao = 0.05;

			for (int i = 0; i < 20; i++) {
				rna.inicializarPesos(entradas.length);
				rna.executar(entradas);
				for (int j = 0; j < entradas.length; j++) {
					bufferedWriter.write(entradas[j].toString().replace('.',
							',')
							+ ";");
					entradas[j] = entradas[j] + discretizacao;
				}
				for (Double saida : rna.getCamadaDeSaida().getVetorSaida()) {
					bufferedWriter.write(saida.toString().replace('.', ',')
							+ ";");
				}
				bufferedWriter.write("\n");
			}
			for (int k = 0; k < rna.getCamadasIntermediarias().size(); k++) {
				bufferedWriter.write("\nPESOS CAMADA INTERMEDIARIA " + (k + 1)
						+ "\n");
				Double[][] pesos = rna.getCamadasIntermediarias().get(k)
						.getPesos();
				for (int i = 0; i < pesos.length; i++) {
					for (int j = 0; j < pesos[i].length; j++) {
						bufferedWriter.write("W" + (i + 1) + (j + 1) + "= "
								+ pesos[i][j].toString().replace('.', ',')
								+ ";");
					}
				}
				bufferedWriter.write("\n");
			}

			bufferedWriter.write("\nPESOS CAMADA DE SAIDA\n");
			Double[][] pesos = rna.getCamadaDeSaida().getPesos();
			for (int i = 0; i < pesos.length; i++) {
				for (int j = 0; j < pesos[i].length; j++) {
					bufferedWriter.write("W" + (i + 1) + (j + 1) + "= "
							+ pesos[i][j].toString().replace('.', ',') + ";");
				}
			}
			bufferedWriter.write("\n");
			bufferedWriter.close();
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static Double[][] lerAqruivo(String caminho, Double[][] matriz){
		try {
			String linha = "";
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(caminho));
			int i = 0;
			while((linha = reader.readLine()) != null){
				String[] valoresLinha = linha.split(";");
				
				for (int j = 0; j < valoresLinha.length; j++) {
					matriz[i][j] = Double.valueOf(valoresLinha[j].replace(",", "."));
				}
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matriz;
	}
}
