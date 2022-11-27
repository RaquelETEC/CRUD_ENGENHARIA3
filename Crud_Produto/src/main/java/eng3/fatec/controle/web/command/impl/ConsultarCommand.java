
package eng3.fatec.controle.web.command.impl;

import eng3.fatec.core.aplicacao.Resultado;
import Model.EntidadeDominio;
import Model.IEntidade;



public class ConsultarCommand extends AbstractCommand{

	
	public Resultado execute(IEntidade entidade) {
		
		return fachada.consultar((EntidadeDominio)entidade);
	}

}
