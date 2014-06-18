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
		return 1 / (1 + StrictMath.exp(-u));
	}

	@Override
	public Double derivada(Double u) {
		Double x = this.ativar(u);
		return x * (1 - x);
	}
	
}
