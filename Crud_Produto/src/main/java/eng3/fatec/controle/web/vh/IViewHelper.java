
package eng3.fatec.controle.web.vh;

import eng3.fatec.core.aplicacao.Resultado;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.IEntidade;


public interface IViewHelper{

	public IEntidade getEntidade(HttpServletRequest request);
	
	public void setView(Resultado resultado, 
			HttpServletRequest request, HttpServletResponse response)throws ServletException;
	
	public void setView(Resultado resultado, ServletConfig config);
}
