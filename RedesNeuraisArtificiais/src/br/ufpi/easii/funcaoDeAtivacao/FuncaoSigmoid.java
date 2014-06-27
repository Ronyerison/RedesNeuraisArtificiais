/**
 * 
 */
package br.ufpi.easii.funcaoDeAtivacao;

/**
 * @author Ronyerison
 *
 */
public class FuncaoSigmoid extends AbstractFunction{

	@Override
	public Double ativar(Double u) {
		Double saida = 1 / (1 + StrictMath.exp(-u));
//		if(saida >= 0.7){
//			saida = 1.0;
//		}
//		if(saida <= 0.3){
//			saida = 0.0;
//		}
		return saida;
	}

	@Override
	public Double derivada(Double u) {
		Double x = this.ativar(u);
		return x * (1 - x);
	}
	
}
