package br.ufpi.easii.redeNeural;

import java.util.ArrayList;
import java.util.List;

import br.ufpi.easii.camadas.CamadaDeSaida;
import br.ufpi.easii.camadas.CamadaIntermediaria;


public class MultiLayerPerceptron {
	
	private List<CamadaIntermediaria> camadasIntermediarias;
	private CamadaDeSaida camadaDeSaida;
	private int quantEpocas;
	private double erroMedio;
	
	public MultiLayerPerceptron(Integer[] camadas) {
		camadasIntermediarias = new ArrayList<CamadaIntermediaria>();
		for (int i = 0; i < (camadas.length-1); i++) {
			CamadaIntermediaria ci = new CamadaIntermediaria(camadas[i]);
			camadasIntermediarias.add(ci);
		}
		camadaDeSaida = new CamadaDeSaida(camadas[camadas.length-1]);
		
	}
	
	@SuppressWarnings("unused")
	public void treinamento(Double[][] amostras, Double[][] esperado, double taxaDeAprendizado, double precisao){
		double erroAnterior, erroTemp;
		inicializarPesos(amostras[0].length);
		this.erroMedio = 0.0;
		this.quantEpocas = 0;
		do{
			erroTemp = 0.0;
			erroAnterior = this.erroMedio;
			
			/*Irá percorrer todas as amostras e calcular o erro médio*/
			for(int i=0; i<amostras.length; i++){
				camadasIntermediarias.get(0).combinarEntradas(amostras[i]);
				camadasIntermediarias.get(0).gerarSaidas();
				for(int j=1; j<camadasIntermediarias.size(); j++){
					camadasIntermediarias.get(j).combinarEntradas(camadasIntermediarias.get(j-1).getVetorSaida());
					camadasIntermediarias.get(j).gerarSaidas();
				}
				camadaDeSaida.combinarEntradas(camadasIntermediarias.get(camadasIntermediarias.size()-1).getVetorSaida());
				camadaDeSaida.gerarSaidas();
				camadaDeSaida.calcularGradiente(esperado[i]);
				camadaDeSaida.ajustarPesos(taxaDeAprendizado, camadasIntermediarias.get(camadasIntermediarias.size()-1).getVetorSaida());
				ajustarCamadasIntermediarias(amostras, taxaDeAprendizado, i);
				erroTemp += calcularErro(esperado[i]);
			}
			erroMedio = erroTemp/amostras.length;
//			System.out.println("ErroMédio " + erroMedio + "\n");
			quantEpocas++;
		} while(Math.abs(this.erroMedio)>precisao);
		
		imprimirCamadaDeSaida();
		
	}
	
	public void executar(Double[] amostras){
		camadasIntermediarias.get(0).combinarEntradas(amostras);
		camadasIntermediarias.get(0).gerarSaidas();
		
		for(int i=1; i<camadasIntermediarias.size(); i++){
			camadasIntermediarias.get(i).combinarEntradas(camadasIntermediarias.get(i-1).getVetorSaida());
			camadasIntermediarias.get(i).gerarSaidas();
		}
		
		camadaDeSaida.combinarEntradas(camadasIntermediarias.get(camadasIntermediarias.size()-1).getVetorSaida());
		camadaDeSaida.gerarSaidas();
		
		imprimeVetor(camadaDeSaida.getVetorSaida());
	}
	
	public void imprimeVetor(Double[] vetor){
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i] + " ");
		}
	}
	
	private void imprimirCamadaDeSaida() {
		for (int i = 0; i < camadaDeSaida.getQuantNeuronios(); i++) {
			for (int j = 0; j < camadaDeSaida.getNeuronios().get(i).getPesos().length; j++) {
				System.out.print(camadaDeSaida.getNeuronios().get(i).getPesos()[j] + " ");
			}
			System.out.println("\n");
		}
		System.out.println("Treinado por " + quantEpocas + " epocas");
	}

	private void ajustarCamadasIntermediarias(Double[][] amostras,
			double taxaDeAprendizado, int i) {
		camadasIntermediarias.get(camadasIntermediarias.size()-1).calcularGradiente(camadaDeSaida);
		for(int j=camadasIntermediarias.size()-1; j>0; j--){
			camadasIntermediarias.get(j).ajustarPesos(taxaDeAprendizado, camadasIntermediarias.get(j-1).getVetorSaida());
			camadasIntermediarias.get(j-1).calcularGradiente(camadasIntermediarias.get(j));
		}
		camadasIntermediarias.get(0).ajustarPesos(taxaDeAprendizado, amostras[i]);
	}
	
	public double calcularErro(Double[] esperado){
		double soma = 0.0;
		
		for(int i=0; i<camadaDeSaida.getVetorSaida().length; i++){
			soma += esperado[i] - camadaDeSaida.getVetorSaida()[i];
		}
		
		return soma;
	}
	public void inicializarPesos(int tam){
		camadasIntermediarias.get(0).gerarPesos(tam);
		for(int i=1; i<camadasIntermediarias.size(); i++){
			camadasIntermediarias.get(i).gerarPesos(camadasIntermediarias.get(i-1).getQuantNeuronios());
		}
		camadaDeSaida.gerarPesos(camadasIntermediarias.get(camadasIntermediarias.size()-1).getQuantNeuronios());
	}
	/**
	 * @param camadasIntermediarias
	 * @param camadaDeSaida
	 */
	public MultiLayerPerceptron(
			List<CamadaIntermediaria> camadasIntermediarias,
			CamadaDeSaida camadaDeSaida) {
		this.camadasIntermediarias = camadasIntermediarias;
		this.camadaDeSaida = camadaDeSaida;
	}

	/**
	 * @return the camadasIntermediarias
	 */
	public List<CamadaIntermediaria> getCamadasIntermediarias() {
		return camadasIntermediarias;
	}
	
	/**
	 * @param camadasIntermediarias the camadasIntermediarias to set
	 */
	public void setCamadasIntermediarias(
			List<CamadaIntermediaria> camadasIntermediarias) {
		this.camadasIntermediarias = camadasIntermediarias;
	}
	
	/**
	 * @return the camadaDeSaida
	 */
	public CamadaDeSaida getCamadaDeSaida() {
		return camadaDeSaida;
	}
	
	/**
	 * @param camadaDeSaida the camadaDeSaida to set
	 */
	public void setCamadaDeSaida(CamadaDeSaida camadaDeSaida) {
		this.camadaDeSaida = camadaDeSaida;
	}
}
