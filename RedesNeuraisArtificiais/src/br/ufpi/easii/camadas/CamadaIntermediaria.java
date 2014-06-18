/**
 * 
 */
package br.ufpi.easii.camadas;

/**
 * @author Ronyerison
 * 
 */
public class CamadaIntermediaria extends Camada {

	public CamadaIntermediaria(int quantNeuronios) {
		super(quantNeuronios);
	}

	public void calcularGradiente(Camada camada){
		Double somaTemp = 0.0;
		for (int i = 0; i < this.neuronios.size(); i++) {
			somaTemp = 0.0;
			for (int j = 0; j < camada.getNeuronios().size(); j++) {
				somaTemp += camada.getNeuronios().get(j).getPesos()[i] * camada.vetorGradiente[j];
			}
			vetorGradiente[i] = neuronios.get(i).derivada() * somaTemp;
		}
	}
	
	
}
