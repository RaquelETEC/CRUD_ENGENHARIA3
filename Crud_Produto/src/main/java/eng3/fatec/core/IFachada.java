package eng3.fatec.core;

import eng3.fatec.core.aplicacao.Resultado;
import Model.EntidadeDominio;
import Model.IEntidade;

public interface IFachada {

	public Resultado salvar(EntidadeDominio entidade);
	public Resultado alterar(EntidadeDominio entidade);
	public Resultado excluir(EntidadeDominio entidade);
	public Resultado consultar(IEntidade entidade);
	public Resultado visualizar(EntidadeDominio entidade);
	
	
	
}
