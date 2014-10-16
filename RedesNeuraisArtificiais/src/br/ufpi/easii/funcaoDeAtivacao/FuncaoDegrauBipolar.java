/**
 * 
 */
package br.ufpi.easii.funcaoDeAtivacao;

/**
 * @author Ronyerison
 *
 */
public class FuncaoDegrauBipolar extends AbstractFunction{

	@Override
	public Double ativar(Double u) {
		if(u >= 0.0){
			return 1.0;
		}else{
			return -1.0;
		}
	}

	@Override
	public Double derivada(Double u) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
