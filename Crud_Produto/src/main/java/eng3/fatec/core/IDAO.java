package eng3.fatec.core;

import java.sql.SQLException;
import java.util.List;

import Model.EntidadeDominio;
import Model.IEntidade;

public interface IDAO {

	public void salvar(EntidadeDominio entidade) throws SQLException;
	public void alterar(EntidadeDominio entidade)throws SQLException;
	public void excluir(EntidadeDominio entidade)throws SQLException;
	public List<EntidadeDominio> consultar(IEntidade entidade)throws SQLException;
	
	
}
