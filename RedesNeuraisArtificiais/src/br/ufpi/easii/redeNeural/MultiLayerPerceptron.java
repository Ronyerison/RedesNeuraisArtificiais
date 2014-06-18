package br.ufpi.easii.redeNeural;

import java.util.ArrayList;
import java.util.List;

import br.ufpi.easii.camadas.CamadaDeSaida;
import br.ufpi.easii.camadas.CamadaIntermediaria;


public class MultiLayerPerceptron {
	
	private List<CamadaIntermediaria> camadasIntermediarias;
	private CamadaDeSaida camadaDeSaida;
	
	public MultiLayerPerceptron(Integer[] camadas) {
		camadasIntermediarias = new ArrayList<CamadaIntermediaria>();
		for (int i = 0; i < (camadas.length-1); i++) {
			CamadaIntermediaria ci = new CamadaIntermediaria(camadas[i]);
			camadasIntermediarias.add(ci);
		}
		camadaDeSaida = new CamadaDeSaida(camadas[camadas.length-1]);
		
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
