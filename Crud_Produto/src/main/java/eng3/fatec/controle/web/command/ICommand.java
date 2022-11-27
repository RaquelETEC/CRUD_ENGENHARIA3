
package eng3.fatec.controle.web.command;

import eng3.fatec.core.aplicacao.Resultado;
import Model.IEntidade;


public interface ICommand {

	public Resultado execute(IEntidade entidade);
	
}
