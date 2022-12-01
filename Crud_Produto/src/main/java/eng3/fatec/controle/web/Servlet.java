package eng3.fatec.controle.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import eng3.fatec.controle.web.vh.impl.*;
import eng3.fatec.controle.web.command.impl.*;
import Model.IEntidade;
import eng3.fatec.core.aplicacao.Resultado;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import eng3.fatec.controle.web.command.ICommand;
import eng3.fatec.controle.web.vh.IViewHelper;

public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;
	private static String uri = null;
	private static HttpServletRequest request;
	private static String operacao = null;
	private static IViewHelper vh;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		Enumeration<String> parametros = config.getInitParameterNames();

		while (parametros.hasMoreElements()) {
			String parametro = parametros.nextElement();
			uri = config.getInitParameter(parametro);
			Resultado resultado = doProcess();

			vh.setView(resultado, config);
		}	
	

	}
	
	public Servlet() {
		commands = new HashMap<String, ICommand>();

		commands.put("SALVAR", new SalvarCommand());
		commands.put("EXCLUIR", new ExcluirCommand());

		ConsultarCommand consultarCMD = new ConsultarCommand();
		commands.put("CONSULTAR", consultarCMD);
		commands.put("PREPARAR_PRODUTO", consultarCMD);

		commands.put("VISUALIZAR", new VisualizarCommand());
		commands.put("ALTERAR", new AlterarCommand());
		
		
		
		vhs = new HashMap<String, IViewHelper>();
	
		vhs.put("/Model/INDEX.html", new ProdutoViewHelper());

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcessRequest(request, response);
	}

	protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		uri = request.getRequestURI();

	

		
		operacao = request.getParameter("operacao");

		Resultado resultado = doProcess();

		vh.setView(resultado, request, response);
	}
	
	
	
	
	
	
	
	protected Resultado doProcess() throws ServletException {

		
		vh = vhs.get(uri);

		
		IEntidade entidade = vh.getEntidade(request);


		if (request == null) {
			operacao = "CONSULTAR";
		} else {
			operacao = request.getParameter("operacao");
		}

		if(operacao != null) {
	
			ICommand command = commands.get(operacao);

		
			Resultado resultado = command.execute(entidade);

			return resultado;
		}
		
		return null;
	}
}

