/**
 * 
 */
package br.ufpi.easii.camadas;

/**
 * @author Ronyerison
 *
 */
public class CamadaDeSaida extends Camada{

	public CamadaDeSaida(int quantNeuronios) {
		super(quantNeuronios);
	}

	public void calcularGradiente(Double[] esperado){
		for (int i = 0; i < neuronios.size(); i++) {
			this.vetorGradiente[i] = (esperado[i] - vetorSaida[i]) * neuronios.get(i).derivada();
		}
		this.somarGradiente();
	}
	
	
}
