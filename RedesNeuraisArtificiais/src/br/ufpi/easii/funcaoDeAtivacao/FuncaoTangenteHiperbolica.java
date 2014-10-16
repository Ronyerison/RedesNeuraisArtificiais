/**
 * 
 */
package br.ufpi.easii.funcaoDeAtivacao;

/**
 * @author Ronyerison
 *
 */
public class FuncaoTangenteHiperbolica extends AbstractFunction{

	@Override
	public Double ativar(Double u) {
		return ((1-StrictMath.exp(-u)) / (1 + StrictMath.exp(-u)));
	}

	@Override
	public Double derivada(Double u) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
