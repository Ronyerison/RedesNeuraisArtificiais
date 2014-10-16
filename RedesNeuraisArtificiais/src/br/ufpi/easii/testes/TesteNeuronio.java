/**
 * 
 */
package br.ufpi.easii.testes;

import org.junit.Assert;
import org.junit.Test;

import br.ufpi.easii.funcaoDeAtivacao.FuncaoDegrau;
import br.ufpi.easii.neuronios.Neuronio;

/**
 * @author Ronyerison
 *
 */
public class TesteNeuronio {

	@Test
	public void questao04Test() {
		Double[] pesos = {1.0, 1.0};
		Neuronio neuronio = new Neuronio(pesos, new FuncaoDegrau(), 1.1);
		Double[] entradas = {1.0, 0.0};
		neuronio.somatorio(entradas);
		Double u = neuronio.getPotencialDeAtivacao();
		Assert.assertEquals(-0.1, u, 0.1);
		neuronio.ativarNeuronio();
		Assert.assertEquals(0.0, neuronio.getSaida(), 0.1);
	}
	
	
}
