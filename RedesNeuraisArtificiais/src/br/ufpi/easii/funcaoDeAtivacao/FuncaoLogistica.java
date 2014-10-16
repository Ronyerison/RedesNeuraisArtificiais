/**
 * 
 */
package br.ufpi.easii.funcaoDeAtivacao;

/**
 * @author Ronyerison
 *
 */
public class FuncaoLogistica extends AbstractFunction{

	@Override
	public Double ativar(Double u) {
		return 1 / (1 + StrictMath.exp(-u));
	}

	@Override
	public Double derivada(Double u) {
		// TODO Auto-generated method stub
		return null;
	}

}
