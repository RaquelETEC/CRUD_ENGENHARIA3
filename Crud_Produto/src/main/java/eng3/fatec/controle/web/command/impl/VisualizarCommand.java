
package eng3.fatec.controle.web.command.impl;

import eng3.fatec.core.aplicacao.Resultado;
import Model.EntidadeDominio;
import Model.IEntidade;


public class VisualizarCommand extends AbstractCommand{

	
	public Resultado execute(IEntidade entidade) {
		
		return fachada.visualizar((EntidadeDominio)entidade);
	}

}