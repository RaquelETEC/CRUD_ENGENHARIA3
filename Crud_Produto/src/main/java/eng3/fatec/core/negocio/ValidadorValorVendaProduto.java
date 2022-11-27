package eng3.fatec.core.negocio;

import eng3.fatec.core.IStrategy;
import Model.IEntidade;
import Model.Produto;

public class ValidadorValorVendaProduto implements IStrategy {

	@Override
	public String processar(IEntidade entidade) {
		
		if(entidade instanceof Produto){
			Produto c = (Produto)entidade;
			
			if(c.getPreco_venda() < 1){
				return "O preço da venda deve ser no minimo 1!";
			}
			
		}else{
			return "Quantidade n�o pode ser v�lidado, pois entidade n�o � um produto!";
		}
		
		
		return null;
	}

}
