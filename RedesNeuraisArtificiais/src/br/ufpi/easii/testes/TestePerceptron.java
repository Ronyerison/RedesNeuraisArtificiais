/**
 * 
 */
package br.ufpi.easii.testes;

import org.junit.Test;

import br.ufpi.easii.redeNeural.MultiLayerPerceptron;
import br.ufpi.easii.redeNeural.Perceptron;

/**
 * @author Ronyerison
 *
 */
public class TestePerceptron {

	@Test
	public void testPerceptron() {
		Perceptron p = new Perceptron();
		Double[][] entradas = new Double[4][2];
		entradas[0][0] = 0.0; entradas[0][1] = 0.0;
		entradas[1][0] = 0.0; entradas[1][1] = 1.0;
		entradas[2][0] = 1.0; entradas[2][1] = 0.0;
		entradas[3][0] = 1.0; entradas[3][1] = 1.0;
		
		Double[] saidaDesejada = {0.0,0.0,1.0,1.0};
		
		p.treinamento(entradas, saidaDesejada, 0.5);
		for(int i=0; i<4; i++){
			p.executar(entradas[i]);
		}
	}
	
	@Test
	public void testMultiLayerPerceptron(){
		Integer[] vet = {2,1};
		MultiLayerPerceptron multiLayerPerceptron = new MultiLayerPerceptron(vet);
		
		Double[][] entradas = new Double[4][2];
		entradas[0][0] = 0.0; entradas[0][1] = 0.0;
		entradas[1][0] = 0.0; entradas[1][1] = 1.0;
		entradas[2][0] = 1.0; entradas[2][1] = 0.0;
		entradas[3][0] = 1.0; entradas[3][1] = 1.0;
		
		Double[][] saidaDesejada = new Double[4][1];
		saidaDesejada[0][0] = 0.0;
		saidaDesejada[1][0] = 1.0;
		saidaDesejada[2][0] = 1.0;
		saidaDesejada[3][0] = 0.0;
		
		multiLayerPerceptron.treinamento(entradas, saidaDesejada, 0.9, 0.09);
		for(int i=0; i<4; i++){
			multiLayerPerceptron.executar(entradas[i]);
		}
	}
}
